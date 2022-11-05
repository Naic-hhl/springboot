package com.example.springboot_ssm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot_ssm.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * @BelongsProject: springboot
 * @BelongsPackage: com.example.springboot_ssm.dao
 * @Author: Naic
 * @CreateTime: 2022-11-01  06:15
 * @Description: TODO
 * @Version: 1.0
 */
@Mapper
public interface ProductDao extends BaseMapper<Product> {

    /*@Select("select * from product where p_id = #{id}")
    Product getById(Integer id);*/

}
