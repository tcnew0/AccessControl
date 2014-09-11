package com.zzb.competence.service.Impl;

import com.zzb.competence.dao.impl.GroupInfoDaoImpl;
import com.zzb.competence.entity.GroupInfo;
import org.springframework.stereotype.Service;

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
}
