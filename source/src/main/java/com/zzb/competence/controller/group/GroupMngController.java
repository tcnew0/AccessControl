package com.zzb.competence.controller.group;

import com.zzb.competence.util.common.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by guanzhenxing on 2014-06-11.
 */
@Controller
@RequestMapping("group")
public class GroupMngController {

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
    public ModelAndView add(){
        ModelAndView mav = new ModelAndView(Constants.GROUP_PAGES.MANAGE);
        
        //mav.addObject()
        return mav;
    }
}
