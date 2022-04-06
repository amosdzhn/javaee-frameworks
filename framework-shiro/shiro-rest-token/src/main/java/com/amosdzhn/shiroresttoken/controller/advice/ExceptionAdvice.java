package com.amosdzhn.shiroresttoken.controller.advice;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionAdvice {


    /**
     * 参数校验异常处理
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public List<String> handleMethodArgumentNotValid(HttpServletRequest req, MethodArgumentNotValidException exception){
        List<String> response = new ArrayList<>();
        BindingResult bindingResult = exception.getBindingResult();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            response.add(fieldError.getDefaultMessage());
        }
        return response;
    }

    /**
     * 全局异常处理
     */
    @ExceptionHandler(value = Exception.class)
    public String handleException(HttpServletRequest req,Exception e){
        return e.getMessage();
    }


    /**
     * 认证异常
     */
    @ExceptionHandler(value = AuthorizationException.class)
    public String shiroAuthorizationHandler( AuthorizationException ae){
        return ae.getMessage();
    }

}
