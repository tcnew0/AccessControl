package com.zzb.competence.controller.common;

import com.zzb.competence.controller.BaseController;
import com.zzb.competence.util.common.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhaozb on 14-6-3.
 */
@Controller
@RequestMapping("login")
public class LoginController extends BaseController{


    /**
     * 登陆跳转到主页面
     * @return
     */
    @RequestMapping("login")
    public String login(){

        return Constants.INDEX_PAGES.MAIN;
    }
}
