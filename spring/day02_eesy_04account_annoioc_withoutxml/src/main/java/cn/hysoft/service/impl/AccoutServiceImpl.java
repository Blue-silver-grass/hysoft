package cn.hysoft.service.impl;

import cn.hysoft.dao.IAccountDao;
import cn.hysoft.domain.Account;
import cn.hysoft.service.IAccoutService;
import cn.hysoft.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service("accountService")
public class AccoutServiceImpl implements IAccoutService {
    @Autowired
    private IAccountDao accoutDao;

    public void setAccoutDao(IAccountDao accoutDao) {
        this.accoutDao = accoutDao;
    }
    @Autowired
    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public List<Account> findAllAccount() throws SQLException {
        try {
            txManager.beginTransaction();
            List<Account> accounts=accoutDao.findAllAccount();
            txManager.commit();
            return accounts;
        }catch (Exception e){
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            txManager.release();
        }
    }

    public Account findAccountById(Integer accountId) {
        try {
            txManager.beginTransaction();
            Account account = accoutDao.findAccountById(accountId);
            txManager.commit();
            return account;
        }catch (Exception e){
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            txManager.release();
        }
    }

    public void saveAccount(Account account) {
        try {
            txManager.beginTransaction();
            accoutDao.saveAccount(account);
            txManager.commit();
        }catch (Exception e){
            txManager.rollback();
        }finally {
            txManager.release();
        }
    }

    public void updateAccount(Account account) {
        try {
            txManager.beginTransaction();
            accoutDao.updateAccount(account);
            txManager.commit();
        }catch (Exception e){
            txManager.rollback();
        }finally {
            txManager.release();
        }
    }

    public void deleteAccount(Integer accountId) {
        try {
            txManager.beginTransaction();
            accoutDao.deleteAccount(accountId);
            txManager.commit();
        }catch (Exception e){
            txManager.rollback();
        }finally {
            txManager.release();
        }
    }

    public void tranfer(String sourceName, String targetName, Float money) {
        try {
            txManager.beginTransaction();
            Account source = accoutDao.findAccountByName(sourceName);
            Account target = accoutDao.findAccountByName(targetName);
            source.setMoney(source.getMoney()-money);
            target.setMoney(target.getMoney()+money);
            accoutDao.updateAccount(source);
//            int i = 1/0;
            accoutDao.updateAccount(target);
            txManager.commit();
        }catch (Exception e){
            txManager.rollback();
            e.printStackTrace();
        }finally {
            txManager.release();
        }

    }
}
