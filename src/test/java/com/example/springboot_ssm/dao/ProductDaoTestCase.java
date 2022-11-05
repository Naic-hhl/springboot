package com.example.springboot_ssm.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot_ssm.pojo.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @BelongsProject: springboot
 * @BelongsPackage: com.example.springboot_ssm.dao
 * @Author: Naic
 * @CreateTime: 2022-11-01  06:18
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootTest
public class ProductDaoTestCase {

    @Autowired
    private ProductDao productDao;

    @Test
    void testGetById(){
        System.out.println("***********************");
        System.out.println(productDao.selectById(1));
        System.out.println("***********************");
    }

    @Test
    void testQueryAll(){
        System.out.println(productDao.selectList(null));
    }

    @Test
    void testSave(){

        Product product = new Product();

        product.setName("yiyi");
        product.setPrice("250");
        product.setCategoryName("无");

        System.out.println("******************");
        productDao.insert(product);
        System.out.println("*******************");
    }

    @Test
    void testDelete(){
        productDao.deleteById(51);
    }

    @Test
    void testUpdate(){
        Product product = new Product();

        product.setId(50);
        product.setName("五十");
        product.setPrice("250");
        product.setCategoryName("无");
        productDao.updateById(product);
    }

    @Test
    void testGetPage(){

        IPage page = new Page(2,3);
        productDao.selectPage(page,null);
        System.out.println(page.getCurrent());
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
    }

    @Test
    void testGetBy(){
        QueryWrapper<Product> qw = new QueryWrapper<>();
        qw.like("category_name","服装");
        productDao.selectList(qw);
    }

    @Test
    void testGetBy2(){
        String name = null;
        LambdaQueryWrapper<Product> lqw = new LambdaQueryWrapper<>();
        //判断输入是否为空的两种方法 true为使用条件,false为不适用条件查询
        //if (name != null)lqw.like(Product::getCategoryName,name);
        lqw.like(name != null,Product::getCategoryName,"服装");
        productDao.selectList(lqw);
    }

}
