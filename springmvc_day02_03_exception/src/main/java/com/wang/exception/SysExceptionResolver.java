package com.wang.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器
 */
public class SysExceptionResolver implements HandlerExceptionResolver {
    /**
     * 异常业务逻辑
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //获取异常对象
        SysException systemException = null;
        if(ex instanceof SysException){
            systemException = (SysException) ex;
        }else {
            systemException = new SysException("系统正在维护");
        }
        ModelAndView view = new ModelAndView();
        view.addObject("errorMsg", ex.getMessage());
        view.setViewName("error");
        return view;
    }
}
