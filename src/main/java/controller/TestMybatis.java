package controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pojo.Product;

public class TestMybatis {
	public static void main(String [] args) throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        
        Product p = session.selectOne("getProduct", 1);
        session.commit();
        session.close();
        
        SqlSession session1 = sqlSessionFactory.openSession();//二级缓存测试
        Product p2 = session1.selectOne("getProduct", 1);
        session1.commit();
        session1.close();
	}
}
