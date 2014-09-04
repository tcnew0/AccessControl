package com.zzb.competence.util.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by guanzhenxing on 2014-08-18.
 */
public class BusinessExceptionHandler implements HandlerExceptionResolver {

    /** log */
    private static Logger log = LoggerFactory.getLogger(BusinessExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        // result
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception",ex.getMessage());

        if(ex instanceof BusinessException){
            mav.setViewName("error/inner_error");
        }else{
            mav.setViewName("error/request_error");
        }

        // print
        log.error(ex.getMessage());
        ex.printStackTrace();

        return mav;
    }
}
