package cn.hysoft.service.impl;

import cn.hysoft.dao.IAccountDao;
import cn.hysoft.domain.Account;
import cn.hysoft.service.IAccoutService;
import cn.hysoft.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.SQLException;
import java.util.List;
public class AccoutServiceImpl implements IAccoutService {

    private IAccountDao accountDao;
    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public List<Account> findAllAccount() throws SQLException {
            List<Account> accounts=accountDao.findAllAccount();
            return accounts;
    }

    public Account findAccountById(Integer accountId) {
            Account account = accountDao.findAccountById(accountId);
            return account;
    }

    public void saveAccount(Account account) {
            accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
            accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
            accountDao.deleteAccount(accountId);
    }

    public void tranfer(final String sourceName, final String targetName, final Float money) {
        transactionTemplate.execute(new TransactionCallback<Object>() {
            public Object doInTransaction(TransactionStatus transactionStatus) {
                Account source = accountDao.findAccountByName(sourceName);
                Account target = accountDao.findAccountByName(targetName);
                source.setMoney(source.getMoney()-money);
                target.setMoney(target.getMoney()+money);
                accountDao.updateAccount(source);
//            int i = 1/0;
                accountDao.updateAccount(target);
                return null;
            }
        });
    }
}
