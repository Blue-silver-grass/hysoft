package cn.hysoft.test;

import cn.hysoft.dao.IUserDao;
import cn.hysoft.dao.impl.UserDaoImpl;
import cn.hysoft.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;


public class MybatisTest {

    private InputStream in  = null;
    private IUserDao userDao = null;

    @Before
    public void init() throws Exception{
        in  = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        userDao = new UserDaoImpl(factory);
    }

    @After
    public void destory() throws Exception {
        in.close();
    }

    @Test
    public void testFindAll() throws Exception {
        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void testSave() throws Exception {
        User user = new User();
        user.setUsername("mybatis dao save");
        user.setAddress("北京市顺义区");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存操作之前"+user);
        userDao.saveUser(user);
        System.out.println("保存操作之后"+user);
    }

    @Test
    public void testUpdate() throws Exception {
        User user = new User();
        user.setId(51);
        user.setUsername("mybatis update dao");
        user.setAddress("北京市雁山区");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.updateUser(user);
    }

    @Test
    public void testDelete() throws Exception {
       userDao.deleteUser(54);
    }

    @Test
    public void testFindOne() throws Exception {
        User user = userDao.findById(51);
        System.out.println(user);
    }

    @Test
    public void testFindByName() throws Exception {
        List<User> list = userDao.findByName("%王%");
//        List<User> list = userDao.findByName("王");
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal() throws Exception {
        int total = userDao.findTotal();
        System.out.println(total);
    }
}
