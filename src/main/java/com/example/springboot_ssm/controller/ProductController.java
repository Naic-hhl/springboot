package com.example.springboot_ssm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.springboot_ssm.pojo.Product;
import com.example.springboot_ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @BelongsProject: springboot
 * @BelongsPackage: com.example.springboot_ssm.controller
 * @Author: Naic
 * @CreateTime: 2022-11-01  08:05
 * @Description: TODO
 * @Version: 1.0
 */
//@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAll() throws Exception {
        return productService.getAll();
    }

    @GetMapping("{id}")
    public Product getById(@PathVariable Integer id){
        return productService.getById(id);
    }

    @PostMapping
    public Boolean addProduct(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("{id}")
    public Boolean deleteProductById(@PathVariable Integer id){
        return productService.delete(id);
    }

    @PutMapping
    public Boolean updateProduct(@RequestBody Product product){
        return productService.update(product);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Product> getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        return productService.getPage(currentPage,pageSize, null);
    }



}
