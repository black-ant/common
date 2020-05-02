package com.gang.common.flowable.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname FLProcessController
 * @Description TODO
 * @Date 2020/4/6 18:05
 * @Created by zengzg
 */
@RestController
@RequestMapping("/flowable/process")
public class FLProcessController {

    @GetMapping("do")
    public String doProcess() {
        return "ok";
    }
}
