package com.zzb.competence.util.exception;

/**
 * Created by guanzhenxing on 2014-08-15.
 */
public enum ExceptionEnum {
    DEFAULT("default","ex_00");

    private String name;
    private String value;

    ExceptionEnum(String name,String value) {
        this.name = name;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
