package com.zzb.competence.controller.group;

import com.zzb.competence.entity.GroupInfo;
import com.zzb.competence.service.BaseService;
import com.zzb.competence.service.Impl.GroupServericeImpl;
import com.zzb.competence.util.common.Constants;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Calendar;

/**
 * Created by guanzhenxing on 2014-06-11.
 */
@Controller
@RequestMapping("group")
public class GroupMngController {

    /** log */
    private static Logger log = LoggerFactory.getLogger(GroupMngController.class);

    @Autowired
    public GroupServericeImpl groupServerice;

    /**
     * list
     * @return
     */
    @RequestMapping("manage")
    public String manage(){
        return Constants.GROUP_PAGES.MANAGE;
    }

    /**
     * add
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ModelAndView add(@RequestParam("grpNum") String grpNum,
                            @RequestParam("grpName") String grpName,
                            @RequestParam("description") String description){
        // 返回的model 对象
        ModelAndView mav = new ModelAndView(Constants.GROUP_PAGES.MANAGE);
        log.info("grpNum={},grpName={},description={}",grpNum,grpName,description);

        // save group info
        GroupInfo groupInfo = new GroupInfo();
        groupInfo.setGroupNum(grpNum);
        groupInfo.setGroupName(grpNum);
        groupInfo.setDescription(description);
        groupInfo.setUseFlag(Constants.STATUS.GROUP.ACTIVE);
        groupInfo.setCreateTime(Calendar.getInstance().getTime());

        groupServerice.getDao().save(groupInfo);

        //mav.addObject()
        return mav;
    }
}
