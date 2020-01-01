package com.gang.common.lib.search;

import lombok.Data;

import java.util.List;

/**
 * @Classname OrderTO
 * @Description TODO
 * @Date 2019/12/7 23:05
 * @Created by zengzg
 */
@Data
public class OrderTO {

    List<orderBy> lisr;


    @Data
    class orderBy {
        private String orderByField;
        private String orderByType;
    }
}
