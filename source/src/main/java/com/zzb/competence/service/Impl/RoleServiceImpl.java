package com.zzb.competence.service.Impl;

import com.zzb.competence.dao.impl.RoleDaoImpl;
import com.zzb.competence.entity.Role;
import com.zzb.competence.util.common.StringOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by guanzhenxing on 2014-09-10.
 */
@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> {

    /** role dao */
    @Autowired
    private RoleDaoImpl roleDao;

    @Override
    public RoleDaoImpl getDao() {
        return roleDao;
    }

    /**
     * save
     * @param role Role
     * @return Role
     */
    @Transactional
    public Role save(Role role){
        return roleDao.save(role);
    }

    /**
     * delete role by ids
     * @param ids ids
     */
    @Transactional
    public void deleteByIds(String ids){

        // 获取要删除的groupinfo
        Iterable<Role> iterator = getDao().findAll(StringOpUtils.StrToLongList(ids, ","));

        getDao().delete(iterator);
    }
}
