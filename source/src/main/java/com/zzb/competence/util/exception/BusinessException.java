package com.zzb.competence.util.exception;

import com.zzb.competence.util.context.CommonMessage;

/**
 * Created by guanzhenxing on 2014-06-22.
 */
public class BusinessException extends Exception{

    private ExceptionEnum type;

    public BusinessException(String message) {
        super(postFullMessage(message,ExceptionEnum.DEFAULT));
    }

    public BusinessException(String message, ExceptionEnum type) {
        super(postFullMessage(message,type));
    }

    public ExceptionEnum getType() {
        return type;
    }

    public void setType(ExceptionEnum type) {
        this.type = type;
    }

    /**
     * 拼接异常信息
     * @param message message
     * @param type ExceptionEnum
     * @return String
     */
    public static String postFullMessage(String message, ExceptionEnum type){
        return CommonMessage.getMessage(type.getValue())+" : " + message;
    }
}
