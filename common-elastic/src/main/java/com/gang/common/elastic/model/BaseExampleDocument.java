package com.gang.common.elastic.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @Classname BaseExampleDocument
 * @Description TODO
 * @Date 2020/4/1 21:49
 * @Created by zengzg
 */
@Data
public class BaseExampleDocument extends BaseBean {

    /**
     * @Description: @Id注解必须是springframework包下的
     * org.springframework.data.annotation.Id
     * @Author: https://blog.csdn.net/chen_2890
     */
    @Id
    private Long id;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title; //标题

    @Field(type = FieldType.Keyword)
    private String category;// 分类

    @Field(type = FieldType.Keyword)
    private String brand; // 品牌

    @Field(type = FieldType.Double)
    private Double price; // 价格

    @Field(index = false, type = FieldType.Keyword)
    private String images; // 图片地址
}
