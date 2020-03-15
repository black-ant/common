package com.gang.common.msgapi.logic;

import java.util.function.Consumer;

/**
 * @Classname IMsgConsumer
 * @Description TODO
 * @Date 2020/3/1 18:48
 * @Created by zengzg
 */
public interface IMsgConsumer {

    void setConsumer(Consumer<String> consumer);

}
