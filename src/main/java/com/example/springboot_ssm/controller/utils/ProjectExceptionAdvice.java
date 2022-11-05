package com.example.springboot_ssm.controller.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @BelongsProject: springboot
 * @BelongsPackage: com.example.springboot_ssm.controller.utils
 * @Author: Naic
 * @CreateTime: 2022-11-01  11:09
 * @Description: TODO
 * @Version: 1.0
 */
//作为springmvc的异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {
    //拦截所有的异常信息
    @ExceptionHandler
    public R doException(Exception ex){

        ex.printStackTrace();
        return new R("服务器故障");
    }

}
