package com.gang.common.msgapi.logic;


import com.gang.common.lib.to.ResponseModel;
import com.gang.common.msgapi.IMsgSetting;
import com.gang.common.msgapi.to.IMsgContent;
import com.gang.common.msgapi.to.MsgBaseBody;

/**
 * @Classname IMsgOperation
 * @Description TODO
 * @Date 2020/2/22 19:28
 * @Created by zengzg
 */
public interface IMsgProduce<C extends IMsgSetting, T extends IMsgContent> {

    Boolean init(C config);

    ResponseModel sendMsg(T msgBody);

}
