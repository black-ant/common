package com.gang.common.lib.to;

import lombok.Data;

import java.util.List;

/**
 * @Classname PageResponse
 * @Description TODO
 * @Date 2019/10/29 23:00
 * @Created by ant-black 1016930479@qq.com
 */
@Data
public class PageResponse<E> {

    String page;

    String size;

    String total;

    List<E> dataList;


}
