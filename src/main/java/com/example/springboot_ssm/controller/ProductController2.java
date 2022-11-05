package com.example.springboot_ssm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.springboot_ssm.controller.utils.R;
import com.example.springboot_ssm.pojo.Product;
import com.example.springboot_ssm.service.IProductService;
import com.example.springboot_ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @BelongsProject: springboot
 * @BelongsPackage: com.example.springboot_ssm.controller
 * @Author: Naic
 * @CreateTime: 2022-11-01  08:05
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/products")
public class ProductController2 {

    @Autowired
    private IProductService productService;

    @GetMapping
    public R getAll() {
        return new R(true, productService.list());

    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true ,productService.getById(id));
    }

    @PostMapping
    public R addProduct(@RequestBody Product product) throws IOException {
        if (product.getName().equals("123")) throw new IOException();
        boolean flag = productService.save(product);
        return new R(flag,flag ? "添加成功" : "添加失败");
    }

    @DeleteMapping("{id}")
    public R deleteProductById(@PathVariable Integer id){
        return new R(productService.removeById(id));
    }

    @PutMapping
    public R updateProduct(@RequestBody Product product){
        return new R(productService.updateById(product));
    }

    /*@GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        IPage<Product> page = productService.getPage(currentPage, pageSize);
        //如果当前页码值大于总页码值,那么重新执行查询操作,使最大页码值作为当前页码值
        if (currentPage > page.getPages()){
            page = productService.getPage((int) page.getPages(),pageSize);
        }
        return new R(true,page);
    }*/

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize ,Product product){
        IPage<Product> page = productService.getPage(currentPage, pageSize, product);
        //如果当前页码值大于总页码值,那么重新执行查询操作,使最大页码值作为当前页码值
        if (currentPage > page.getPages()){
            page = productService.getPage((int) page.getPages(),pageSize,product);
        }
        return new R(true,page);
    }



}
