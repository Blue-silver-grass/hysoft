package cn.hysoft.test;

import cn.hysoft.dao.IRoleDao;
import cn.hysoft.dao.IUserDao;
import cn.hysoft.domain.Role;
import cn.hysoft.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class RoleTest {
    private InputStream in  = null;
    private SqlSession sqlSession = null;
    private IRoleDao roleDao = null;

    @Before
    public void init() throws Exception{
        in  = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        roleDao = sqlSession.getMapper(IRoleDao.class);
    }

    @After
    public void destory() throws Exception {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
    @Test
    public void testFindAll(){
        List<Role> roles = roleDao.findAll();
        for (Role role : roles){
            System.out.println("----每个角色信息------");
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }
}
