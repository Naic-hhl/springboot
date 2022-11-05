package com.example.springboot_ssm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: springboot
 * @BelongsPackage: com.example.springboot_ssm.pojo
 * @Author: Naic
 * @CreateTime: 2022-11-01  06:10
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer id;

    private String name;

    private String price;

    private String categoryName;
}
