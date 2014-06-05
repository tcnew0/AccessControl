package com.zzb.competence.controller.common;

import com.zzb.competence.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhaozb on 14-6-3.
 */
@Controller
@RequestMapping("login")
public class LoginController extends BaseController{

    @RequestMapping("login")
    public String login(){

        return LOGIN;
    }
}
