package com.example.springboot_ssm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot_ssm.dao.ProductDao;
import com.example.springboot_ssm.pojo.Product;
import com.example.springboot_ssm.service.IProductService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: springboot
 * @BelongsPackage: com.example.springboot_ssm.service.impl
 * @Author: Naic
 * @CreateTime: 2022-11-01  07:54
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductDao, Product> implements IProductService {

    @Autowired
    private ProductDao productDao;



    @Override
    public IPage<Product> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        productDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Product> getPage(int currentPage, int pageSize, Product product) {

        LambdaQueryWrapper<Product> lqw = new LambdaQueryWrapper<Product>();
        lqw.like(Strings.isNotEmpty(product.getName()),Product::getName,product.getName());
        lqw.like(Strings.isNotEmpty(product.getPrice()),Product::getPrice,product.getPrice());
        lqw.like(Strings.isNotEmpty(product.getCategoryName()),Product::getCategoryName,product.getCategoryName());

        IPage page = new Page(currentPage,pageSize);
        productDao.selectPage(page,lqw);

        return page;
    }
}
