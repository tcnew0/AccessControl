package com.zzb.competence.dao.impl;

import com.zzb.competence.dao.BaseDao;
import com.zzb.competence.entity.GroupInfo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by guanzhenxing on 2014-07-08.
 */
@Repository("groupDao")
public interface GroupInfoDaoImpl extends BaseDao<GroupInfo,Long> {

   public GroupInfo findByGroupName(String name);
}
