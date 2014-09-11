package com.zzb.competence.service.Impl;

import com.zzb.competence.dao.impl.RoleDaoImpl;
import com.zzb.competence.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
