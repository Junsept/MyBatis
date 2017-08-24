package controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mapper.ProductMapper;
import pojo.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestSpringMybatis {
    @Autowired
    private ProductMapper productMapper;
    
    @Test
    public void testAdd() {
        Product product = new Product();
        product.setName("new Product");
        productMapper.addProduct(product);
    }
    
    @Test
    public void testList() {
        System.out.println(productMapper);
        List<Product> cs = productMapper.listProduct();
        for (Product c : cs) {
            System.out.println(c.getName());
        }
    }
}
