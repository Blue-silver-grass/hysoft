package cn.hysoft.dao;

import cn.hysoft.domain.QueryVo;
import cn.hysoft.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
    User findById(Integer id);
    List<User> findByName(String username);

    List<User> findUserByVo(QueryVo vo);
    List<User> findUserByCondition(User user);
    List<User> findUserInIds(QueryVo vo);
}
