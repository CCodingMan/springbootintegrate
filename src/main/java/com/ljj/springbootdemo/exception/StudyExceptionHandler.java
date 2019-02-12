package com.ljj.springbootdemo.exception;

import com.ljj.springbootdemo.utils.JSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: ljj
 * @Date: 2019/2/12 11:03
 * @Description:异常处理类
 */
@ControllerAdvice
public class StudyExceptionHandler {
    private static final String ERROR_VIEW = "freemarker/error";

    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request,
                               HttpServletResponse response, Exception e) throws Exception {
        e.printStackTrace();

        if(isAjax(request)) {
            return JSONResult.errorException(e.getMessage());
        }else {
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e.getMessage());
            mav.addObject("url", request.getRequestURL());
            mav.setViewName(ERROR_VIEW);
            return mav;
        }
    }

    /**
     * 判断是否为ajax请求
     * @param request
     * @return
     */
    private static boolean isAjax(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null
                && "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
    }
}
