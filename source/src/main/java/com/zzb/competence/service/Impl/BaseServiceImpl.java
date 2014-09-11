package com.zzb.competence.service.Impl;

import com.zzb.competence.dao.BaseDao;
import com.zzb.competence.entity.Menu;
import com.zzb.competence.service.BaseService;
import com.zzb.competence.util.common.Constants;
import com.zzb.competence.util.common.StringOpUtils;
import com.zzb.competence.util.context.MyBeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;

/**
 * Created by zhaozb on 14-5-26.
 */
public abstract class BaseServiceImpl<T> implements BaseService {

    private Class<T> clazz;


    @Autowired
    private MyBeanFactory myBeanFactory;

    /**
     * constructor
     */
    protected BaseServiceImpl() {
        this.clazz = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * get class
     *
     * @return
     */
    public Class<T> getClazz() {
        return clazz;
    }

    /**
     * get MyBeanFactory
     *
     * @return
     */
    public MyBeanFactory getMyBeanFactory() {
        return myBeanFactory;
    }

    /**
     * get dao,convert to concrete dao
     *
     * @param <E>
     * @return
     */
    public abstract <E extends BaseDao> E getDao();

    /**
     * get base dao type
     *
     * @param <F>
     * @return
     */
    public <F extends BaseDao> F getFDao() {
        Class c = null;
        try {
            c = Class.forName(Constants.PROJECT_INFO.BASE_PAKAGE + ".dao.impl." + getClazz().getSimpleName() + "DaoImpl");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return (F)getMyBeanFactory().getBean(c);
    }

    /**
     * delete entity by ids
     * @param ids
     */
    @Transactional
    public void deleteByIds(String ids){

        // 获取要删除的groupinfo
        Iterable<T> iterator = getDao().findAll(StringOpUtils.StrToLongList(ids, ","));

        getDao().delete(iterator);
    }

    /**
     * save object
     * @param obj object
     * @return object
     */
    @Transactional
    public Object save(Object obj){
        return getDao().save(obj);
    }
}
