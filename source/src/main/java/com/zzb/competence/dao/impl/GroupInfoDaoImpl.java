package com.zzb.competence.dao.impl;

import com.zzb.competence.dao.BaseDao;
import com.zzb.competence.entity.GroupInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Created by guanzhenxing on 2014-07-08.
 */
@Repository("groupDao")
public interface GroupInfoDaoImpl extends BaseDao<GroupInfo,Long> {

    @Query("select g from GroupInfo g where g.groupName like ?1 and g.groupNum like ?2 ")
    public Page<GroupInfo> findByGroupNameAndGroupNum(String groupName,String groupNum, Pageable pageable);
}
