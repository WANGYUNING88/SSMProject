package com.wang.test;

import com.wang.dao.AccountDao;
import com.wang.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    @Test
    public void run1() throws IOException {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession sqlSession = factory.openSession();
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        //查询所有数据
        List<Account> all = mapper.findAll();
        for(Account account : all){
            System.out.println(account.toString());
        }
        sqlSession.close();
        in.close();

    }
    @Test
    public void run2() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        Account account = new Account();
        account.setMoney(100.0);
        account.setName("admin");
        mapper.saveAccount(account);
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

}
