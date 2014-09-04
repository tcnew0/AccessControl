package com.zzb.competence.controller.group;

import com.zzb.competence.controller.common.CommonController;
import com.zzb.competence.entity.GroupInfo;
import com.zzb.competence.service.Impl.GroupServericeImpl;
import com.zzb.competence.util.common.Constants;
import com.zzb.competence.util.common.PageInfo;
import com.zzb.competence.util.common.StringOpUtils;
import com.zzb.competence.util.exception.BusinessException;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Calendar;

/**
 * Created by guanzhenxing on 2014-06-11.
 */
@Controller
@RequestMapping("group")
public class GroupMngController extends CommonController{

    /** log */
    private static Logger log = LoggerFactory.getLogger(GroupMngController.class);

    @Autowired
    public GroupServericeImpl groupService;

    /**
     * list
     * @return ModelAndView
     */
    @RequestMapping("manage")
    public ModelAndView manage(Model model) throws BusinessException {

        // find all
        Page<GroupInfo> groups = groupService.getDao().findAll(this.postPageableInfo());

        ModelAndView mav = new ModelAndView(Constants.GROUP_PAGES.MANAGE);
        mav.addObject("groups",groups);
        // 分页
//        mav.addObject("page",new PageInfo(groups.getNumber()+1, Constants.PAGE_INFO.DEFAULT_PAGE_CNT
//                ,groups.getTotalPages(),groups.getTotalElements()));

        mav.addObject("message","操作成功!");

        return mav;
    }

    /**
     * search
     * @return
     */
    @RequestMapping(value = "searchJson")
    public ModelAndView searchJson(){
        // get parameter from request
        String groupNum =  StringOpUtils.escapeStr(
                ObjectUtils.toString(request.getParameter("groupNum")),
                Constants.SQL_CONSTANTS.ESCAPE);
        String groupName = StringOpUtils.escapeStr(
                ObjectUtils.toString(request.getParameter("groupName")),
                Constants.SQL_CONSTANTS.ESCAPE);

        // find all
        Page<GroupInfo> groups = groupService.getDao().findByGroupNameAndGroupNum("%"+groupName+"%","%"+groupNum+"%",this.postPageableInfo());
        ModelAndView mav = new ModelAndView(Constants.GROUP_PAGES.FRAME);
        mav.addObject("groups",groups);
        // 分页
        mav.addObject("page",new PageInfo(groups.getNumber()+1, Constants.PAGE_INFO.DEFAULT_PAGE_CNT
                ,groups.getTotalPages(),groups.getTotalElements()));

        // 传递参数
        mav.addObject("groupNum",groupNum);
        mav.addObject("groupName",groupName);
        return mav;
    }

    /**
     * add
     * @return ModelAndView
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ModelAndView add(@RequestParam("grpNum") String grpNum,
                            @RequestParam("grpName") String grpName,
                            @RequestParam("description") String description){
        // 返回的model 对象
        ModelAndView mav = new ModelAndView("redirect:manage");
        log.info("grpNum={},grpName={},description={}",grpNum,grpName,description);

        // save group info
        GroupInfo groupInfo = new GroupInfo();
        groupInfo.setGroupNum(grpNum);
        groupInfo.setGroupName(grpNum);
        groupInfo.setDescription(description);
        groupInfo.setUseFlag(Constants.STATUS.GROUP.ACTIVE);
        groupInfo.setCreateTime(Calendar.getInstance().getTime());

        groupService.save(groupInfo);

        return mav;
    }

    /**
     * 根据id查找部门
     * @return ModelAndView
     */
    @RequestMapping("search/{id}")
    public ModelAndView findGroupById(@PathVariable Long id){
        // 返回的model 对象
        ModelAndView mav = new ModelAndView("redirect:manage");
        log.info("id:"+id);
        GroupInfo group = groupService.getDao().findOne(id);
        return mav;
    }

    /**
     * 更新部门
     * @return ModelAndView
     */
    @RequestMapping(value="modify",method = RequestMethod.PUT)
    public ModelAndView updateGroup(@ModelAttribute GroupInfo group){
        // 返回的model 对象
        ModelAndView mav = new ModelAndView("redirect:manage");
        log.info(group.getGroupNum()+":"+group.getGroupName()+" will be modified.");
        // save
        groupService.save(group);
        return mav;
    }

    /**
     * 删除部门
     * @param ids
     * @return
     */
    @RequestMapping(value="delete",method = RequestMethod.DELETE)
    public ModelAndView deleteGroup(@RequestParam("ids") String ids){
        ModelAndView mav = new ModelAndView("redirect:searchJson");
        log.info("ids:" + ids);
        groupService.deleteByIds(ids);
        return mav;
    }
}
