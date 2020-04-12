package cn.hysoft.service;

import cn.hysoft.domain.Account;

import java.sql.SQLException;
import java.util.List;

public interface IAccoutService {
    List<Account> findAllAccount() throws SQLException;

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);

    void tranfer(String sourceName,String targetName,Float money);
}
