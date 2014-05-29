package com.zzb.competence.service.Impl;

import com.zzb.competence.dao.BaseDao;
import com.zzb.competence.service.BaseService;
import com.zzb.competence.util.context.MyBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.reflect.ParameterizedType;

/**
 * Created by zhaozb on 14-5-26.
 */
public abstract class BaseServiceImpl<E, T extends BaseDao> implements BaseService {

    private Class<T> clazz;


    @Autowired
    private MyBeanFactory myBeanFactory;

    /**
     * constructor
     */
    protected BaseServiceImpl() {
        this.clazz = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
    }

    /**
     * get dao
     *
     * @param <T>
     * @return
     */
    public <T> T getDao() {
        return (T)myBeanFactory.getBean(clazz);
    }
}
