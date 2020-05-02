package com.gang.common.msg.logic;

import com.gang.common.lib.exception.CommonException;
import com.gang.common.msg.IMsgSetting;
import com.gang.common.msg.to.IMsgContent;

/**
 * @Classname BaseSendServiceManager
 * @Description TODO
 * @Date 2020/2/22 22:10
 * @Created by zengzg
 */
public abstract class BaseSendServiceManager<C extends IMsgSetting, T extends IMsgContent> implements IMsgProduce<C,
        T> {

    static ThreadLocal<IMsgSetting> threadLocal = new ThreadLocal<IMsgSetting>();

    @Override
    public Boolean init(C config) {
        if (config == null) {
            throw new CommonException("Msg Setting is Null");
        }
        threadLocal.set(config);
        return Boolean.TRUE;
    }

    public C getSetting() {
        return (C) threadLocal.get();
    }
}
