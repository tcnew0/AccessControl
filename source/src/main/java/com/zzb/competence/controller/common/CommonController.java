package com.zzb.competence.controller.common;

import com.zzb.competence.controller.BaseController;
import com.zzb.competence.util.common.Constants;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhaozb on 14-6-3.
 */
@Controller
@RequestMapping("/index")
public class CommonController extends BaseController{

    @Autowired
    protected HttpServletRequest request;

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

    /**
     * get request
     * @param request
     * @return
     */
    public HttpServletRequest getRequest(HttpServletRequest request){
        return request;
    }

    /**
     * post page info
     * @return Pageable
     */
    public Pageable postPageableInfo(){

        // get current page
        String curPageStr = request.getParameter(Constants.PAGE_INFO.CUR_PAGE);
        int curPage = StringUtils.isEmpty(curPageStr) ? Constants.PAGE_INFO.DEFAULT_CUR_PAGE
                : Integer.valueOf(curPageStr);

        // page size
        String pageSizeStr = request.getParameter(Constants.PAGE_INFO.PAGE_SIZE);
        int pageSize = StringUtils.isEmpty(pageSizeStr) ? Constants.PAGE_INFO.DEFAULT_PAGE_SIZE
                :Integer.valueOf(pageSizeStr);

        // page
        Pageable pageable = new PageRequest(curPage-1,pageSize);

        return pageable;
    }
}