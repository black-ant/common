package com.gang.common.lib.exception;

import com.gang.common.lib.to.ResponseError;

/**
 * @Classname AntExceptionUtils
 * @Description TODO
 * @Date 2020/5/3 23:06
 * @Created by zengzg
 */
public final class AntExceptionUtils {

    private AntExceptionUtils() {
    }

    public static ResponseError buildErrorTO(Exception exception) {

        ResponseError error = new ResponseError();

        if (exception instanceof CommonException) {

            CommonException commonException = (CommonException) exception;
            error.setErrorCode(commonException.getCode());
            error.setErrorInfo(commonException.getMessage());
            error.setErrorMap(commonException.getVar());
        } else {
            error.setErrorInfo(exception.getMessage());
            error.setErrorInfo(AntCommonErrorType.SERVER_ERROR.getCode());
        }
        return error;

    }
}
