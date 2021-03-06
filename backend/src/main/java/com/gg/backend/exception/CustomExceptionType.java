package com.gg.backend.exception;

/**
 * @author Gimi
 * @date 2019/6/8 11:47
 */
public enum CustomExceptionType {
    SYSTEM_ERROR( "500" , "系统异常"),
    NO_PERMISSION( "501" , "您没有操作权限"),
    VALIDATE_ERR("502","参数有误！"),
    TOKEN_FAIL("503","token失效！");


    private String errorCode;
    private String message;

    CustomExceptionType(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
