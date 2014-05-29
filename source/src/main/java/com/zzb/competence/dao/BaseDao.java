package com.zzb.competence.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by zhaozb on 14-5-28.
 */
@NoRepositoryBean
public interface BaseDao<T, ID extends java.io.Serializable> extends CrudRepository{
}
