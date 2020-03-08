package cn.hysoft.dao;

import cn.hysoft.domain.QueryVo;
import cn.hysoft.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Integer id);
    User findById(Integer id);
    List<User> findByName(String username);
    int findTotal();

    List<User> findUserByVo(QueryVo vo);
}
