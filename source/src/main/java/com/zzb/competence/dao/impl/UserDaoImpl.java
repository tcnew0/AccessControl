package com.zzb.competence.dao.impl;

import com.zzb.competence.dao.BaseDao;
import com.zzb.competence.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by zhaozb on 14-5-28.
 */
@Repository("userDao")
public interface UserDaoImpl extends BaseDao<User,Long>{
    public User findByName(String name);
}
