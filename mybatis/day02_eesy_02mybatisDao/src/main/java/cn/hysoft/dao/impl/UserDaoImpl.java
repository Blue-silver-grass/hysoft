package cn.hysoft.dao.impl;

import cn.hysoft.dao.IUserDao;
import cn.hysoft.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory factory;
    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }
    public List<User> findAll() {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("cn.hysoft.dao.IUserDao.findAll");
        session.close();
        return users;
    }

    public void saveUser(User user) {
        SqlSession session = factory.openSession();
        session.insert("cn.hysoft.dao.IUserDao.saveUser",user);
        session.commit();
        session.close();
    }

    public void updateUser(User user) {
        SqlSession session = factory.openSession();
        session.update("cn.hysoft.dao.IUserDao.updateUser",user);
        session.commit();
        session.close();
    }

    public void deleteUser(Integer id) {
        SqlSession session = factory.openSession();
        session.delete("cn.hysoft.dao.IUserDao.deleteUser",id);
        session.commit();
        session.close();
    }

    public User findById(Integer id) {
        SqlSession session = factory.openSession();
        User user = session.selectOne("cn.hysoft.dao.IUserDao.findById",id);
        session.close();
        return user;
    }

    public List<User> findByName(String username) {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("cn.hysoft.dao.IUserDao.findByName",username);
        session.close();
        return users;
    }

    public int findTotal() {
        SqlSession session = factory.openSession();
        Integer count = session.selectOne("cn.hysoft.dao.IUserDao.findTotal");
        session.close();
        return count;
    }
}
