package cn.hysoft.test;

import cn.hysoft.dao.IUserDao;
import cn.hysoft.domain.QueryVo;
import cn.hysoft.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MybatisTest {

    private InputStream in  = null;
    private SqlSession sqlSession = null;
    private IUserDao userDao = null;

    @Before
    public void init() throws Exception{
        in  = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destory() throws Exception {
        sqlSession.commit();
        sqlSession.close();
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
    public void testFindOne() throws Exception {
        User user = userDao.findById(51);
        System.out.println(user);
    }

    @Test
    public void testFindByName() throws Exception {
//        List<User> list = userDao.findByName("%王%");
        List<User> list = userDao.findByName("王");
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindByQueryVo() throws Exception {
        QueryVo vo = new QueryVo();
        User user  = new User();
        user.setUserName("%王%");
        vo.setUser(user);
        List<User> list = userDao.findUserByVo(vo);
        for (User u : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindByCondition() throws Exception {
        User u = new User();
        u.setUserName("mybatis update dao");
        u.setUserSex("女");
        List<User> users = userDao.findUserByCondition(u);
        System.out.println("123");
        for (User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void testFindUserInIds() throws Exception {
        QueryVo vo = new QueryVo();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(41);
        ids.add(42);
        ids.add(53);
        vo.setIds(ids);
        List<User> users = userDao.findUserInIds(vo);
        System.out.println("123");
        for (User user : users){
            System.out.println(user);
        }
    }
}
