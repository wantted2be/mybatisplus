package com.company.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.mybatisplus.mapper.ProductMapper;
import com.company.mybatisplus.pojo.Product;
import com.company.mybatisplus.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @Author wlb10
 * @PackageName mybatisplus
 * @Package com.company.mybatisplus.service.impl
 * @Date 2022/7/27 7:37
 * @Version 1.0
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
