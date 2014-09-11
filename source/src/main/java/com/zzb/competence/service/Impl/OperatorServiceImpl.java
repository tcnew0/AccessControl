package com.zzb.competence.service.Impl;

import com.zzb.competence.dao.BaseDao;
import com.zzb.competence.dao.impl.OperatorDaoImpl;
import com.zzb.competence.entity.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by guanzhenxing on 2014-09-10.
 */
@Service("opService")
public class OperatorServiceImpl extends BaseServiceImpl<Operator>{

    /** operatorDao */
    @Autowired
    private OperatorDaoImpl operatorDao;

    @Override
    public OperatorDaoImpl getDao() {
        return operatorDao;
    }
}
