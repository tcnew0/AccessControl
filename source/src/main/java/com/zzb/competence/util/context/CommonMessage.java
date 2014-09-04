package com.zzb.competence.util.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Locale;

/**
 * Created by guanzhenxing on 2014-08-18.
 */
public class CommonMessage implements ApplicationContextAware{

    /** applicationContext */
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CommonMessage.applicationContext = applicationContext;
    }

    /**
     * 根据key、时区获取信息
     * @param key
     * @param locale
     * @return
     */
    public static String getMessage(String key,Locale locale){
        return applicationContext.getMessage(key,null,locale);
    }

    /**
     * 默认时区获取信息
     * @param key
     * @return
     */
    public static String getMessage(String key){
        return applicationContext.getMessage(key,null,Locale.getDefault());
    }

    /**
     * 根据key、替代参数和时区获取信息
     * @param key
     * @param objects
     * @param locale
     * @return
     */
    public static String getMessage(String key,Object[] objects,Locale locale){
        return applicationContext.getMessage(key,objects,locale);
    }

    /**
     *  根据key、替代参数和默认时区获取信息
     * @param key
     * @param objects
     * @return
     */
    public static String getMessage(String key,Object[] objects){
        return applicationContext.getMessage(key,objects,Locale.getDefault());
    }

    /**
     *  根据key、替代参数、默认消息和时区获取信息
     * @param key
     * @param objects
     * @param defaultMsg
     * @param locale
     * @return
     */
    public static String getMessage(String key,Object[] objects,String defaultMsg,Locale locale){
        return applicationContext.getMessage(key,objects,defaultMsg,locale);
    }

    /**
     * 根据key、替代参数、默认消息和默认时区获取信息
     * @param key
     * @param objects
     * @param defaultMsg
     * @return
     */
    public static String getMessage(String key,Object[] objects,String defaultMsg){
        return applicationContext.getMessage(key,objects,defaultMsg,Locale.getDefault());
    }

    /**
     * get application
     * @return
     */
    public static ApplicationContext getSource(){
        return applicationContext;
    }
}
