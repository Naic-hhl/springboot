package com.example.springboot_ssm.service;

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
public class ProductServiceTestCase {

    @Autowired
    private ProductService productService;

    @Test
    void testGetById(){
        System.out.println(productService.getById(3));
    }

    @Test
    void testGetAll(){
        productService.getAll();
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
        productService.delete(52);
    }

    @Test
    void testUpdate(){
        Product product = new Product();
        product.setId(53);
        product.setName("五十三");
        product.setPrice("53");
        product.setCategoryName("无");
        productService.update(product);
    }

    @Test
    void testGetByPage(){
        productService.getPage(2,3, null);
    }


}
