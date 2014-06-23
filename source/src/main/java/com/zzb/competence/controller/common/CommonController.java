package com.zzb.competence.controller.common;

import com.zzb.competence.controller.BaseController;
import com.zzb.competence.util.common.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhaozb on 14-6-3.
 */
@Controller
@RequestMapping("/index")
public class CommonController extends BaseController{

    /**
     * index
     * @return
     */
    @RequestMapping("index")
    public String index(){
        return Constants.INDEX_PAGES.INDEX;
    }

    /**
     * iframe
     * @return
     */
    @RequestMapping("iframe")
    public String frame(){
        return Constants.INDEX_PAGES.IFRAME;
    }
}
