package cn.hysoft.service.impl;

import cn.hysoft.dao.IAccountDao;
import cn.hysoft.dao.impl.AccountDaoImpl;
import cn.hysoft.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    IAccountDao accountDao = new AccountDaoImpl();
    public AccountServiceImpl(){
        System.out.println("service对象创建了");
    }
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
