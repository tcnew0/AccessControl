package com.zzb.competence.helloworld;

import java.lang.reflect.ParameterizedType;

/**
 * Created by zhaozb on 14-5-28.
 */
public class T1<T,M> {
    private Class<T> clazzT;
    private Class<M> clazzM;
    T1(){
        this.clazzT = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.clazzM = (Class<M>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<T> getClazzT() {
        return clazzT;
    }

    public Class<M> getClazzM() {
        return clazzM;
    }
}

