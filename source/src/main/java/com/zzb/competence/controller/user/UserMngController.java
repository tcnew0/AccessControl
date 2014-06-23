package com.zzb.competence.controller.user;

import com.zzb.competence.util.common.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by guanzhenxing on 2014-06-21.
 */
@Controller
@RequestMapping("user")
public class UserMngController {

    /**
     * 主界面
     * @return
     */
    @RequestMapping("manage")
    public String manage(){
        return Constants.USER_PAGES.MANAGE;
    }
}
