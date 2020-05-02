package com.gang.common.sms;

import com.cloopen.rest.sdk.BodyType;
import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.gang.common.entity.RYSmsSetting;
import com.gang.common.entity.SmsMsgContent;
import com.gang.common.lib.to.ResponseModel;
import com.gang.common.msg.logic.BaseSendServiceManager;
import com.gang.common.msg.to.MsgRequestTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Classname RYSmsLogic
 * @Description TODO
 * @Date 2020/5/2 19:30
 * @Created by zengzg
 */
@Component
public class RYSmsLogic extends BaseSendServiceManager<RYSmsSetting, SmsMsgContent> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public ResponseModel sendMsg(MsgRequestTO<SmsMsgContent, RYSmsSetting> requestTO) {
        process(requestTO.getContentTO(), getSetting());
        return ResponseModel.commonResponse("Send Success");
    }

    public void process(SmsMsgContent sendContent, RYSmsSetting msgSetting) {

        HashMap<String, Object> result;

        CCPRestSmsSDK sdk = new CCPRestSmsSDK();
        sdk.init(msgSetting.getServerIP(), msgSetting.getServerPort());
        sdk.setAccount(msgSetting.getSid(), msgSetting.getAuthToken());
        sdk.setAppId(msgSetting.getAppId());
        sdk.setBodyType(BodyType.Type_JSON);

        String templateKey =
                StringUtils.isNotBlank(sendContent.getTemplateCode()) && !"string".equals(sendContent.getTemplateCode()) ? sendContent.getTemplateCode()
                        : msgSetting.getTemplateKey();

        ArrayList<String> arrayList = new ArrayList();

        arrayList.add(String.valueOf(msgSetting.getTime()));

        result = sdk.sendTemplateSMS(sendContent.getReceiverList(), templateKey,
                arrayList.toArray(new String[]{}));
        if (!"000000".equals(result.get("statusCode"))) {
            logger.error("E----> Send Error ");
        }

    }


}
