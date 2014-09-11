package com.zzb.competence.dao.impl;

import com.zzb.competence.dao.BaseDao;
import com.zzb.competence.entity.Operator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by guanzhenxing on 2014-09-10.
 */
@Repository("opDao")
public interface OperatorDaoImpl extends BaseDao<Operator,Long>{

    /**
     * 根据name 和num 查看op
     * @param opName opName
     * @param opNum opNum
     * @param pageable pageable
     * @return Page<Operator>
     */
    @Query("select g from Operator g where g.opName like ?1  and g.opNum like ?2 " +
            "or g.opName is null or g.opNum is null order by g.createTime desc")
    public Page<Operator> findByOpNameAndOpNum(String opName,String opNum, Pageable pageable);
}
