package com.example.springboot_ssm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot_ssm.pojo.Product;

/**
 * @BelongsProject: springboot
 * @BelongsPackage: com.example.springboot_ssm.service
 * @Author: Naic
 * @CreateTime: 2022-11-01  07:52
 * @Description: TODO
 * @Version: 1.0
 */
public interface IProductService extends IService<Product> {


    IPage<Product> getPage(int currentPage,int pageSize);
    IPage<Product> getPage(int currentPage,int pageSize,Product product);



}
