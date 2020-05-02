package com.gang.common.msg.logic;

import com.gang.common.lib.to.ResponseModel;
import com.gang.common.lib.utils.ReflectionUtils;
import com.gang.common.msg.IMsgSetting;
import com.gang.common.msg.to.IMsgContent;
import com.gang.common.msg.error.MsgException;
import com.gang.common.msg.to.MsgRequestTO;
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

    @Autowired
    private ReflectionUtils reflectionUtils;

    public IMsgProduce getInstance(IMsgSetting config) {
        IMsgProduce<IMsgSetting, IMsgContent> msgOperation =
                reflectionUtils.springClassLoad(config.getMsgType().getLoadClass());
        if (msgOperation == null) {
            throw new MsgException("This operation Class is unload");
        }
        msgOperation.init(config);
        return msgOperation;
    }

}
