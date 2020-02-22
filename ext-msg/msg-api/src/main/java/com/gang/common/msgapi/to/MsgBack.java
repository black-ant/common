package com.gang.common.msgapi.to;

import com.gang.common.lib.annotation.GFiled;
import lombok.Data;

/**
 * @Classname MsgResponse
 * @Description TODO
 * @Date 2020/2/22 20:46
 * @Created by zengzg
 */
@Data
public class MsgBack {

    private Boolean status;

    private String backInfo;

    @GFiled(type = "JSON")
    private String failureInfo;
}
