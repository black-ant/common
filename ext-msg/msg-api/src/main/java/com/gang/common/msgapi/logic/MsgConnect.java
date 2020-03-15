package com.gang.common.msgapi.logic;

import com.gang.common.lib.to.ResponseModel;
import com.gang.common.lib.utils.ReflectionUtils;
import com.gang.common.msgapi.IMsgSetting;
import com.gang.common.msgapi.config.BaseMsgConfig;
import com.gang.common.msgapi.error.MsgException;
import com.gang.common.msgapi.to.IMsgContent;
import com.gang.common.msgapi.to.MsgBaseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Classname MsgConnect
 * @Description TODO
 * @Date 2020/3/1 12:17
 * @Created by zengzg
 */
@Component
public class MsgConnect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private IMsgSetting config;
    private IMsgProduce<IMsgSetting, IMsgContent> msgOperation;

    @Autowired
    private ReflectionUtils reflectionUtils;

    public MsgConnect build(IMsgSetting config) {
        this.config = config;
        return this;
    }

    public static MsgConnect buildStatic(IMsgSetting config) {
        MsgConnect connect = new MsgConnect();
        connect.config = config;
        return connect;
    }

    public ResponseModel send(IMsgContent sendBody) {
        msgOperation = reflectionUtils.springClassLoad(config.getMsgType().getLoadClass());
        if (msgOperation == null) {
            throw new MsgException("This operation Class is unload");
        }
        logger.info("------> this is in send logic :{} <-------", config.getMsgType());

        msgOperation.init(config);
        return ResponseModel.commonResponse(msgOperation.sendMsg(sendBody));
    }


}
