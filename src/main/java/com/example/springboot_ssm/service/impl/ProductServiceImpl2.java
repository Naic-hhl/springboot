package com.example.springboot_ssm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot_ssm.dao.ProductDao;
import com.example.springboot_ssm.pojo.Product;
import com.example.springboot_ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: springboot
 * @BelongsPackage: com.example.springboot_ssm.service.impl
 * @Author: Naic
 * @CreateTime: 2022-11-01  07:32
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class ProductServiceImpl2 implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Boolean save(Product product) {
        return productDao.insert(product) > 0;
    }

    @Override
    public Boolean update(Product product) {
        return productDao.updateById(product) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return productDao.deleteById(id) > 0;
    }

    @Override
    public Product getById(Integer id) {
        return productDao.selectById(id);
    }

    @Override
    public List<Product> getAll() {
        return productDao.selectList(null);
    }

    @Override
    public IPage<Product> getPage(int currentPage, int pageSize, Product product) {
        IPage page = new Page(currentPage,pageSize);
        productDao.selectPage(page,null);
        return page;
    }


}
