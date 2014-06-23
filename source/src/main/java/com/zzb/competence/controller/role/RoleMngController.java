package com.zzb.competence.controller.role;

import com.zzb.competence.util.common.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by guanzhenxing on 2014-06-21.
 */
@Controller
@RequestMapping("role")
public class RoleMngController {

    /**
     * 角色管理主界面
     * @return
     */
    @RequestMapping("manage")
    public String manage(){
        return Constants.ROLE_PAGES.MANAGE;
    }
}
