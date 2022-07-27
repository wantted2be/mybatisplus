package com.company.mybatisplusdatasource;

import com.company.mybatisplusdatasource.service.ProductService;
import com.company.mybatisplusdatasource.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisplusdatasourceApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @Test
    public void test(){
        System.out.println(userService.getById(5));
        System.out.println(productService.getById(1));
    }

}
