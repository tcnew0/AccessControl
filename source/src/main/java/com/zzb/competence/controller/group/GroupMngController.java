package com.zzb.competence.controller.group;

import com.zzb.competence.util.common.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by guanzhenxing on 2014-06-11.
 */
@Controller
@RequestMapping("group")
public class GroupMngController {

    @RequestMapping("manage")
    public String manage(){
        return Constants.GROUP_PAGES.MANAGE;
    }
}
