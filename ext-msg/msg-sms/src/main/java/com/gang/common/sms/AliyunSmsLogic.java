package com.gang.common.sms;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.gang.common.entity.AliyunSetting;
import com.gang.common.entity.SmsMsgContent;
import com.gang.common.lib.to.ResponseModel;
import com.gang.common.msg.logic.BaseSendServiceManager;
import com.gang.common.msg.to.MsgRequestTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Classname AliyunSmsLogic
 * @Description TODO
 * @Date 2020/3/14 16:23
 * @Created by zengzg
 */
@Component
public class AliyunSmsLogic extends BaseSendServiceManager<AliyunSetting, SmsMsgContent> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public ResponseModel sendMsg(MsgRequestTO<SmsMsgContent, AliyunSetting> requestTO) {

        SmsMsgContent msgBody = requestTO.getContentTO();

        AliyunSetting setting = getSetting();
        DefaultProfile profile = DefaultProfile.getProfile(setting.getRegionId(), setting.getAccessToken(),
                setting.getAccessSecret());

        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();

        request.setDomain(setting.getDomain());
        request.setAction(setting.getAction());
        request.setVersion(setting.getVersion());
        request.putQueryParameter("PhoneNumbers", msgBody.getReceiverList());
        request.putQueryParameter("RegionId", setting.getRegionId());
        request.putQueryParameter("SignName", setting.getSignName());

        String templateCode = StringUtils.isBlank(msgBody.getTemplateCode())
                ? setting.getTemplateCode()
                : msgBody.getTemplateCode();
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("TemplateParam", msgBody.getJsonObject().toJSONString());

        try {
            CommonResponse response = client.getCommonResponse(request);
            Map<?, ?> result = JSONObject.parseObject(response.getData(), Map.class);
            if (!"OK".equals(result.get("Code"))) {
                logger.info("------> :{} <-------", JSONObject.toJSONString(result));
            }
            return ResponseModel.commonResponse(String.valueOf(result.get("Message")));
        } catch (
                Exception e) {
            logger.error("E----> error :{} -- content :{}", e.getClass() + e.getMessage(), e);
        }

        return ResponseModel.commonResponse("Send Error");
    }


}
