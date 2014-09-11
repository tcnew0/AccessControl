package com.zzb.competence.controller.menu;

import com.zzb.competence.controller.common.CommonController;
import com.zzb.competence.entity.Menu;
import com.zzb.competence.service.Impl.MenuServiceImpl;
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
 * Created by guanzhenxing on 2014-09-10.
 */
@Controller
@RequestMapping("menu")
public class MenuMngController  extends CommonController {

    /** log */
    private static final Logger log = LoggerFactory.getLogger(MenuMngController.class);

    /** menu service */
    @Autowired
    private MenuServiceImpl menuService;

    /**
     * 角色管理主界面
     * @return
     */
    @RequestMapping("manage")
    public ModelAndView manage(){
        // find all
        Page<Menu> menus = menuService.getDao().findAll(this.postPageableInfo());

        ModelAndView mav = new ModelAndView(Constants.MENU_PAGES.MANAGE);
        mav.addObject("menus",menus);

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
        String menuNum =  StringOpUtils.escapeStr(
                ObjectUtils.toString(request.getParameter("menuNum")),
                Constants.SQL_CONSTANTS.ESCAPE);
        String menuName = StringOpUtils.escapeStr(
                ObjectUtils.toString(request.getParameter("menuName")),
                Constants.SQL_CONSTANTS.ESCAPE);

        // find all
        Page<Menu> menus = menuService.getDao().findByMenuNameAndMenuNum("%" + menuName + "%", "%" + menuNum + "%", this.postPageableInfo());
        ModelAndView mav = new ModelAndView(Constants.MENU_PAGES.FRAME);
        mav.addObject("menus",menus);
        // 分页
        mav.addObject("page",new PageInfo(menus.getNumber()+1, Constants.PAGE_INFO.DEFAULT_PAGE_CNT
                ,menus.getTotalPages(),menus.getTotalElements()));

        // 传递参数
        mav.addObject("menuNum",menuNum);
        mav.addObject("menuName",menuName);
        return mav;
    }

    /**
     * add
     * @return ModelAndView
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute Menu menu){
        // 返回的model 对象
        ModelAndView mav = new ModelAndView("redirect:manage");

        // save menu info
        menu.setUseFlag(Constants.STATUS.COMMON.ACTIVE);
        menu.setCreateTime(Calendar.getInstance().getTime());

        menuService.save(menu);

        return mav;
    }

    /**
     * 更新部门
     * @return ModelAndView
     */
    @RequestMapping(value="modify",method = RequestMethod.PUT)
    public ModelAndView updateMenu(@ModelAttribute Menu menu){
        // 返回的model 对象
        ModelAndView mav = new ModelAndView("redirect:manage");
        log.info(menu.getMenuNum()+":"+menu.getMenuName()+" will be modified.");
        // save
        menuService.save(menu);
        return mav;
    }

    /**
     * 删除部门
     * @param ids
     * @return
     */
    @RequestMapping(value="delete",method = RequestMethod.DELETE)
    public ModelAndView deleteMenu(@RequestParam("ids") String ids){
        ModelAndView mav = new ModelAndView("redirect:searchJson");
        log.info("ids:" + ids);

        menuService.deleteByIds(ids);
        return mav;
    }
}
