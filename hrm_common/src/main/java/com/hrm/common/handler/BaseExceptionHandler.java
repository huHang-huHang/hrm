package com.hrm.common.handler;

import com.hrm.common.entity.Result;
import com.hrm.common.entity.ResultCode;
import com.hrm.common.exception.CommonException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义的公共异常处理器
 *      1.声明异常处理器
 *      2.对异常统一处理
 */
@ControllerAdvice
public class BaseExceptionHandler {
    @ExceptionHandler(value = AuthorizationException.class)
    @ResponseBody
    public Result error(HttpServletRequest request, HttpServletResponse response, AuthorizationException e) {
        return new Result(ResultCode.UNAUTHORISE);
    }

    //@ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(HttpServletRequest request,HttpServletResponse response,Exception e){
        if (e.getClass()==CommonException.class){
            //如果异常是自定义的异常类型，则进行类型转换
            CommonException exception = (CommonException) e;
            //取出其中的resultCode
            ResultCode resultCode = exception.getResultCode();
            //返回Result代码
            return new Result(resultCode);
        }else {
            //如果不是自定义异常类型，则直接返回错误的Result
            return Result.ERROR();
        }
    }

}
