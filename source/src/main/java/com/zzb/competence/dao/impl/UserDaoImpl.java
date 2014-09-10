package com.zzb.competence.dao.impl;

import com.zzb.competence.dao.BaseDao;
import com.zzb.competence.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by zhaozb on 14-5-28.
 */
@Repository("userDao")
public interface UserDaoImpl extends BaseDao<User,Long>{

    /**
     * 根据账号和姓名查询
     * @param loginName loginName
     * @param name name
     * @param pageable pageable
     * @return Page<User>
     */
    @Query("select g from User g where g.loginName like :loginName and g.name like :name order by g.createTime desc")
    public Page<User> findByLoginNameAndName(@Param("loginName") String loginName,@Param("name")String name, Pageable pageable);
}
