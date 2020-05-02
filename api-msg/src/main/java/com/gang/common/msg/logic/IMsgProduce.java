package com.gang.common.msg.logic;


import com.gang.common.lib.to.ResponseModel;
import com.gang.common.msg.IMsgSetting;
import com.gang.common.msg.to.IMsgContent;
import com.gang.common.msg.to.MsgRequestTO;

/**
 * @Classname IMsgOperation
 * @Description TODO
 * @Date 2020/2/22 19:28
 * @Created by zengzg
 */
public interface IMsgProduce<C extends IMsgSetting, T extends IMsgContent> {

    Boolean init(C config);

    ResponseModel sendMsg(MsgRequestTO<T, C> requestTO);

}
