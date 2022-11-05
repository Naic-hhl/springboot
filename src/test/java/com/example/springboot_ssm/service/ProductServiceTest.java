package com.example.springboot_ssm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot_ssm.pojo.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @BelongsProject: springboot
 * @BelongsPackage: com.example.springboot_ssm.service
 * @Author: Naic
 * @CreateTime: 2022-11-01  07:36
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private IProductService productService;

    @Test
    void testGetById(){
        System.out.println(productService.getById(3));
    }

    @Test
    void testGetAll(){
        productService.list();
    }

    @Test
    void testSave(){
        Product product = new Product();
        product.setName("五十五");
        product.setPrice("55");
        product.setCategoryName("无");
        productService.save(product);
    }

    @Test
    void testDelete(){
        productService.removeById(53);
    }

    @Test
    void testUpdate(){
        Product product = new Product();
        product.setId(54);
        product.setName("五十四");
        product.setPrice("53");
        product.setCategoryName("无");
        productService.updateById(product);
    }

    @Test
    void testGetByPage(){
        IPage<Product> page = new Page<>(2,4);
        productService.page(page);
        page.getPages();//页数
        page.getCurrent();//起始页
        page.getRecords();//数据
        page.getSize();//分页数量
        page.getTotal();//总数量
    }


}
