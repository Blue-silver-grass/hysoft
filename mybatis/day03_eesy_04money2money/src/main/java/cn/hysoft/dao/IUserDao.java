package cn.hysoft.dao;

import cn.hysoft.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
    User findById(Integer id);


}
