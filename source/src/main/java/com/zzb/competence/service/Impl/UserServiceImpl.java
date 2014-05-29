package com.zzb.competence.service.Impl;

import com.zzb.competence.dao.impl.UserDaoImpl;
import com.zzb.competence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhaozb on 14-5-26.
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User,UserDaoImpl>{

    @Autowired
    private UserDaoImpl userDao;

    public void test(){

    }
}
