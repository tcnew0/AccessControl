package com.zzb.competence.controller.role;

import com.zzb.competence.controller.common.CommonController;
import com.zzb.competence.entity.Role;
import com.zzb.competence.service.Impl.RoleServiceImpl;
import com.zzb.competence.util.common.Constants;
import com.zzb.competence.util.common.PageInfo;
import com.zzb.competence.util.common.StringOpUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;

/**
 * Created by guanzhenxing on 2014-06-21.
 */
@Controller
@RequestMapping("role")
public class RoleMngController extends CommonController{

    /** log */
    private static final Logger log = LoggerFactory.getLogger(RoleMngController.class);

    /** role service */
    @Autowired
    private RoleServiceImpl roleService;

    /**
     * 角色管理主界面
     * @return
     */
    @RequestMapping("manage")
    public ModelAndView manage(){
        // find all
        Page<Role> roles = roleService.getDao().findAll(this.postPageableInfo());

        ModelAndView mav = new ModelAndView(Constants.ROLE_PAGES.MANAGE);
        mav.addObject("roles",roles);

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
        String roleNum =  StringOpUtils.escapeStr(
                ObjectUtils.toString(request.getParameter("roleNum")),
                Constants.SQL_CONSTANTS.ESCAPE);
        String roleName = StringOpUtils.escapeStr(
                ObjectUtils.toString(request.getParameter("roleName")),
                Constants.SQL_CONSTANTS.ESCAPE);

        // find all
        Page<Role> roles = roleService.getDao().findByRoleNameAndRoleNum("%" + roleName + "%", "%" + roleNum + "%", this.postPageableInfo());
        ModelAndView mav = new ModelAndView(Constants.ROLE_PAGES.FRAME);
        mav.addObject("roles",roles);
        // 分页
        mav.addObject("page",new PageInfo(roles.getNumber()+1, Constants.PAGE_INFO.DEFAULT_PAGE_CNT
                ,roles.getTotalPages(),roles.getTotalElements()));

        // 传递参数
        mav.addObject("roleNum",roleNum);
        mav.addObject("roleName",roleName);
        return mav;
    }

    /**
     * add
     * @return ModelAndView
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ModelAndView add(@RequestParam("roleNum") String roleNum,
                            @RequestParam("roleName") String roleName,
                            @RequestParam("description") String description){
        // 返回的model 对象
        ModelAndView mav = new ModelAndView("redirect:manage");
        log.info("roleNum={},roleName={},description={}",roleNum,roleName,description);

        // save role info
        Role role = new Role();
        role.setRoleNum(roleNum);
        role.setRoleName(roleNum);
        role.setDescription(description);
        role.setUseFlag(Constants.STATUS.COMMON.ACTIVE);
        role.setCreateTime(Calendar.getInstance().getTime());

        roleService.save(role);

        return mav;
    }

    /**
     * 更新部门
     * @return ModelAndView
     */
    @RequestMapping(value="modify",method = RequestMethod.PUT)
    public ModelAndView updateRole(@ModelAttribute Role role){
        // 返回的model 对象
        ModelAndView mav = new ModelAndView("redirect:manage");
        log.info(role.getRoleNum()+":"+role.getRoleName()+" will be modified.");
        // save
        roleService.save(role);
        return mav;
    }

    /**
     * 删除部门
     * @param ids
     * @return
     */
    @RequestMapping(value="delete",method = RequestMethod.DELETE)
    public ModelAndView deleteRole(@RequestParam("ids") String ids){
        ModelAndView mav = new ModelAndView("redirect:searchJson");
        log.info("ids:" + ids);

        roleService.deleteByIds(ids);
        return mav;
    }
}
