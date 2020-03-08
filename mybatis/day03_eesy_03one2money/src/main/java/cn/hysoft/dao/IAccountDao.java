package cn.hysoft.dao;

import cn.hysoft.domain.Account;
import cn.hysoft.domain.AccountUser;

import java.util.List;

public interface IAccountDao {
    List<Account> findAll();
    List<AccountUser> findAllAccount();

}
