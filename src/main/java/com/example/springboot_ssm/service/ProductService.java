package com.example.springboot_ssm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.springboot_ssm.pojo.Product;

import java.util.List;

/**
 * @BelongsProject: springboot
 * @BelongsPackage: com.example.springboot_ssm.service
 * @Author: Naic
 * @CreateTime: 2022-11-01  07:30
 * @Description: TODO
 * @Version: 1.0
 */
public interface ProductService {

    Boolean save(Product product);
    Boolean update(Product product);
    Boolean delete(Integer id);
    Product getById(Integer id);
    List<Product> getAll();
    IPage<Product> getPage(int currentPage, int pageSize, Product product);

}
