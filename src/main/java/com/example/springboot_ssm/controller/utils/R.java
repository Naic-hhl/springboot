package com.example.springboot_ssm.controller.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: springboot
 * @BelongsPackage: com.example.springboot_ssm.controller.utils
 * @Author: Naic
 * @CreateTime: 2022-11-01  08:56
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class R {

    private Boolean flag;

    private Object data;

    private String msg;

    public R(Boolean flag){
        this.flag = flag;
    }

    public R(Boolean flag,Object data){
        this.flag = flag;
        this.data = data;
    }

    public R(String msg){
        this.msg = msg;
    }
}
