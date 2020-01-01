package com.gang.common.lib.to;

import lombok.Data;

/**
 * @Classname PageQuery
 * @Description TODO
 * @Date 2019/10/29 23:02
 * @Created by ant-black 1016930479@qq.com
 */
@Data
public class PageQuery {

    String page;
    String size;
    String desc;

    @Data
    class OrderModel {
        String orderFiled;
        String orderType;
    }

}
