package com.zzb.competence.util.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;

/**
 * Created by zhaozb on 14-5-27.
 */
public class MyBeanFactory implements BeanFactoryAware{

    /** BeanFactory */
    private static BeanFactory beanFactory;

    /** ApplicationContext */
    //private static ApplicationContext applicationContext;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    /**
     * 根据beanName 取得bean
     * @param beanName
     * @param <T>
     * @return
     */
    public <T> T getBean(String beanName){
        if(beanFactory != null){
            return (T)beanFactory.getBean(beanName);
        }
        return null;
    }

    public <T> T getBean(Class<T> clazz){
        if(beanFactory != null){
            return (T)beanFactory.getBean(clazz);
        }
        return null;
    }

    /**
     * get beanFactory.
     * @return
     */
    public BeanFactory getBeanFactory(){
        return beanFactory;
    }
}
