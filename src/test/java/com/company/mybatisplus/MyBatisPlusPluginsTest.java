package com.company.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.mybatisplus.mapper.ProductMapper;
import com.company.mybatisplus.mapper.UserMapper;
import com.company.mybatisplus.pojo.Product;
import com.company.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.PublicKey;
import java.util.List;

/**
 * @Author wlb10
 * @PackageName mybatisplus
 * @Package com.company.mybatisplus
 * @Date 2022/7/27 6:44
 * @Version 1.0
 */
@SpringBootTest
public class MyBatisPlusPluginsTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testPage(){
        //设置分页参数
        Page<User> page = new Page<>(3, 5);
        userMapper.selectPage(page, null);
        //获取分页数据
        List<User> records = page.getRecords();
        System.out.println(page);
        records.forEach(System.out::println);
        System.out.println("当前页码：" + page.getCurrent());
        System.out.println("每一页的大小：" + page.getSize());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        System.out.println("是否有上一页：" + page.hasPrevious());
        System.out.println("是否有下一页：" + page.hasNext());
    }

    @Test
    public void testSelectPageVo(){
        //设置分页参数
        Page<User> page = new Page<>(1, 5);
        userMapper.selectPageVo(page, 18);
        //获取分页数据
        List<User> records = page.getRecords();
        records.forEach(System.out::println);
        System.out.println("当前页码：" + page.getCurrent());
        System.out.println("每一页的大小：" + page.getSize());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        System.out.println("是否有上一页：" + page.hasPrevious());
        System.out.println("是否有下一页：" + page.hasNext());
    }
    
    @Autowired
    private ProductMapper productMapper;
    
    @Test
    public void testConCurrentUpdate(){
        //1.小李
        Product product1 = productMapper.selectById(1L);
        System.out.println("小李取出的商品的价格：" + product1.getPrice());
        
        //2.小王
        Product product2 = productMapper.selectById(1L);
        System.out.println("小王取出的商品的价格：" + product2.getPrice());
        
        //3.小李将价格加了50元存入数据库
        product1.setPrice(product1.getPrice() + 50);
        int i1 = productMapper.updateById(product1);
        System.out.println("小李修改的结果：" + i1);

        //4.小王将商品减了30元，存入了数据库
        product2.setPrice(product2.getPrice() - 30);
        int i2 = productMapper.updateById(product2);
        System.out.println("小王修改的结果：" + i2);

        //5.最终的结果
        Product product3 = productMapper.selectById(1L);
        System.out.println(product3.getPrice());
    }

    @Test
    public void testConCurrentVersionUpdate(){
        //小李取数据
        Product product1 = productMapper.selectById(1L);
        //小王取数据
        Product product2 = productMapper.selectById(1L);
        //小李修改
        product1.setPrice(product1.getPrice() + 50);
        int result1 = productMapper.updateById(product1);
        if(result1 == 0){
            //失败重试，重新获取version并更新
            product1 = productMapper.selectById(1L);
            product1.setPrice(product1.getPrice() + 50);
            result1 = productMapper.updateById(product2);
        }
        System.out.println("小李修改的结果：" + result1);
        //小王修改 - 30
        product2.setPrice(product2.getPrice() - 30);
        int result2 = productMapper.updateById(product2);
        System.out.println("小王修改的结果：" + result2);
        if(result2 == 0){
            //失败重试，重新获取version并更新
            product2 = productMapper.selectById(1L);
            product2.setPrice(product2.getPrice() - 30);
            result2 = productMapper.updateById(product2);
        }
        System.out.println("小王修改重试的结果：" + result2);
        //老板看价格
        Product product3 = productMapper.selectById(1L);
        System.out.println("老板看价格：" + product3.getPrice());
    }
}
