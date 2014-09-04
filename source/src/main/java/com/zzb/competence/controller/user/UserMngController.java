package com.zzb.competence.controller.user;

import com.zzb.competence.controller.common.CommonController;
import com.zzb.competence.entity.GroupInfo;
import com.zzb.competence.entity.User;
import com.zzb.competence.service.Impl.UserServiceImpl;
import com.zzb.competence.util.common.Constants;
import com.zzb.competence.util.common.PageInfo;
import com.zzb.competence.util.common.StringOpUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by guanzhenxing on 2014-06-21.
 */
@Controller
@RequestMapping("user")
public class UserMngController  extends CommonController {

    /**log */
    private static final Logger log= LoggerFactory.getLogger(UserMngController.class);

    @Autowired
    private UserServiceImpl userService;

    /**
     * 主界面
     * @return
     */
    @RequestMapping("manage")
    public ModelAndView manage(){

        // find all
        Page<User> users = userService.getDao().findAll(this.postPageableInfo());

        ModelAndView mav = new ModelAndView(Constants.USER_PAGES.MANAGE);
        mav.addObject("users",users);

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
        String login =  StringOpUtils.escapeStr(
                ObjectUtils.toString(request.getParameter("login")),
                Constants.SQL_CONSTANTS.ESCAPE);
        String name = StringOpUtils.escapeStr(
                ObjectUtils.toString(request.getParameter("name")),
                Constants.SQL_CONSTANTS.ESCAPE);

        // find all
        Page<User> users = userService.getDao().findByLoginNameAndName("%"+login+"%","%"+name+"%",this.postPageableInfo());
        ModelAndView mav = new ModelAndView(Constants.USER_PAGES.FRAME);
        mav.addObject("users",users);
        // 分页
        mav.addObject("page",new PageInfo(users.getNumber()+1, Constants.PAGE_INFO.DEFAULT_PAGE_CNT
                ,users.getTotalPages(),users.getTotalElements()));

        // 传递参数
        mav.addObject("login",login);
        mav.addObject("name",name);
        return mav;
    }

    /**
     * add
     * @return ModelAndView
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute User user){
        // 返回的model 对象
        ModelAndView mav = new ModelAndView("redirect:manage");
        log.info("loginName:"+user.getLoginName());

        // set
        user.setCreateTime(Calendar.getInstance().getTime());
        user.setUseFlag(true);

        userService.save(user);
        return mav;
    }

    /**
     * 更新
     * @return ModelAndView
     */
    @RequestMapping(value="modify",method = RequestMethod.PUT)
    public ModelAndView updateGroup(@ModelAttribute User user){
        // 返回的model 对象
        ModelAndView mav = new ModelAndView("redirect:manage");

        // save
        userService.save(user);
        return mav;
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping(value="delete",method = RequestMethod.DELETE)
    public ModelAndView deleteGroup(@RequestParam("ids") String ids){
        ModelAndView mav = new ModelAndView("redirect:searchJson");
        log.info("ids:" + ids);
        userService.deleteByIds(ids);
        return mav;
    }
}
