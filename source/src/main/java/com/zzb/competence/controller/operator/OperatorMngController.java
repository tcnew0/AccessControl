package com.zzb.competence.controller.operator;

import com.zzb.competence.controller.common.CommonController;
import com.zzb.competence.entity.Operator;
import com.zzb.competence.service.Impl.OperatorServiceImpl;
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
@RequestMapping("op")
public class OperatorMngController extends CommonController{

    /** log */
    private static final Logger log = LoggerFactory.getLogger(OperatorMngController.class);

    /** operator service */
    @Autowired
    private OperatorServiceImpl operatorService;

    /**
     * 角色管理主界面
     * @return
     */
    @RequestMapping("manage")
    public ModelAndView manage(){
        // find all
        Page<Operator> ops = operatorService.getDao().findAll(this.postPageableInfo());

        ModelAndView mav = new ModelAndView(Constants.OP_PAGES.MANAGE);
        mav.addObject("ops",ops);

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
        String opNum =  StringOpUtils.escapeStr(
                ObjectUtils.toString(request.getParameter("opNum")),
                Constants.SQL_CONSTANTS.ESCAPE);
        String opName = StringOpUtils.escapeStr(
                ObjectUtils.toString(request.getParameter("opName")),
                Constants.SQL_CONSTANTS.ESCAPE);

        // find all
        Page<Operator> ops = operatorService.getDao().findByOpNameAndOpNum("%" + opName + "%", "%" + opNum + "%", this.postPageableInfo());
        ModelAndView mav = new ModelAndView(Constants.OP_PAGES.FRAME);
        mav.addObject("ops",ops);
        // 分页
        mav.addObject("page",new PageInfo(ops.getNumber()+1, Constants.PAGE_INFO.DEFAULT_PAGE_CNT
                ,ops.getTotalPages(),ops.getTotalElements()));

        // 传递参数
        mav.addObject("opNum",opNum);
        mav.addObject("opName",opName);
        return mav;
    }

    /**
     * add
     * @return ModelAndView
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute Operator operator){
        // 返回的model 对象
        ModelAndView mav = new ModelAndView("redirect:manage");

        // save operator info
        operator.setCreateTime(Calendar.getInstance().getTime());

        operatorService.save(operator);

        return mav;
    }

    /**
     * 更新部门
     * @return ModelAndView
     */
    @RequestMapping(value="modify",method = RequestMethod.PUT)
    public ModelAndView updateOperator(@ModelAttribute Operator operator){
        // 返回的model 对象
        ModelAndView mav = new ModelAndView("redirect:manage");
        log.info(operator.getOpNum()+":"+operator.getOpName()+" will be modified.");
        // save
        operatorService.save(operator);
        return mav;
    }

    /**
     * 删除部门
     * @param ids
     * @return
     */
    @RequestMapping(value="delete",method = RequestMethod.DELETE)
    public ModelAndView deleteOperator(@RequestParam("ids") String ids){
        ModelAndView mav = new ModelAndView("redirect:searchJson");
        log.info("ids:" + ids);

        operatorService.deleteByIds(ids);
        return mav;
    }
}
