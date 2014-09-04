package com.zzb.competence.service.Impl;

import com.zzb.competence.dao.impl.GroupInfoDaoImpl;
import com.zzb.competence.entity.GroupInfo;
import com.zzb.competence.util.common.StringOpUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guanzhenxing on 2014-07-10.
 */
@Service("groupService")
public class GroupServericeImpl extends BaseServiceImpl<GroupInfo> {

    /**
     * get dao
     * @return
     */
    @Override
    public GroupInfoDaoImpl getDao() {
        return this.getFDao();
    }

    /**
     * save
     * @param group
     * @return
     */
    @Transactional
    public GroupInfo save(GroupInfo group){
        return getDao().save(group);
    }

    /**
     * delete group by ids
     * @param ids
     */
    @Transactional
    public void deleteByIds(String ids){

        // 获取要删除的groupinfo
        Iterable<GroupInfo> iterator = getDao().findAll(StringOpUtils.StrToLongList(ids, ","));

        getDao().delete(iterator);
    }
}
