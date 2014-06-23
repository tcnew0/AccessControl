package com.zzb.competence.util.exception;

/**
 * Created by guanzhenxing on 2014-06-22.
 */
public class BaseException extends Exception{
    private String type;
    private String message;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
