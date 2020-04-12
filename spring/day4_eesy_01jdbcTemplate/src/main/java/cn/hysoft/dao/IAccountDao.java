package cn.hysoft.dao;

import cn.hysoft.domain.Account;

public interface IAccountDao {
    Account findAccountById(Integer accontId);

    Account findAccountByName(String accountName);

    void update(Account account);
}
