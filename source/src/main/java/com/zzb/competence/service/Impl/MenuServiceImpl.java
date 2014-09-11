package com.zzb.competence.service.Impl;

import com.zzb.competence.dao.impl.MenuDaoImpl;
import com.zzb.competence.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by guanzhenxing on 2014-09-10.
 */
@Service("menuService")
public class MenuServiceImpl extends BaseServiceImpl<Menu>{

    /** menu dao */
    @Autowired
    private MenuDaoImpl menuDao;

    @Override
    public MenuDaoImpl getDao() {
        return menuDao;
    }
}
