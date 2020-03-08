package com.hysoft.test;

import com.hysoft.dao.IUserDao;
import com.hysoft.dao.impl.UserDaoImpl;
import com.hysoft.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 *
 */
public class MybatisTest {
    /**
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂创建dao对象
        IUserDao userDao = new UserDaoImpl(factory);
        //4..使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println(user);
        }
        in.close();
    }
}
