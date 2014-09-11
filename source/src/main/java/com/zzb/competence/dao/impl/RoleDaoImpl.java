package com.zzb.competence.dao.impl;

import com.zzb.competence.dao.BaseDao;
import com.zzb.competence.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by guanzhenxing on 2014-09-10.
 */
@Repository("roleDao")
public interface RoleDaoImpl extends BaseDao<Role,Long> {

    @Query("select g from Role g where g.roleName like ?1  and g.roleNum like ?2 " +
            "or g.roleName is null or g.roleNum is null order by g.createTime desc")
    public Page<Role> findByRoleNameAndRoleNum(String roleName,String roleNum, Pageable pageable);
}
