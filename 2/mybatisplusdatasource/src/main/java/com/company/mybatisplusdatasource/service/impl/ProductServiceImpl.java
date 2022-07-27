package com.company.mybatisplusdatasource.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.mybatisplusdatasource.mapper.ProductMapper;
import com.company.mybatisplusdatasource.pojo.Product;
import com.company.mybatisplusdatasource.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @Author wlb10
 * @PackageName mybatisplus
 * @Package com.company.mybatisplus.service.impl
 * @Date 2022/7/27 7:37
 * @Version 1.0
 */
@Service
@DS("slave_1")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
