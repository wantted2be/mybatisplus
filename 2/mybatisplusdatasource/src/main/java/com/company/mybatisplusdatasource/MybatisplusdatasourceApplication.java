package com.company.mybatisplusdatasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.company.mybatisplusdatasource.mapper")  //扫描mapper接口所在的包
public class MybatisplusdatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisplusdatasourceApplication.class, args);
    }

}
