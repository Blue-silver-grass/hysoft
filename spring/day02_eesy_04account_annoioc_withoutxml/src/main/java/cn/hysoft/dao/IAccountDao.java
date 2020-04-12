package cn.hysoft.dao;

import cn.hysoft.domain.Account;

import java.sql.SQLException;
import java.util.List;

public interface IAccountDao {
    List<Account> findAllAccount() throws SQLException;

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);

    Account findAccountByName(String accountName);
}
