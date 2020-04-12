package cn.hysoft.service.impl;

import cn.hysoft.dao.IAccountDao;
import cn.hysoft.dao.impl.AccountDaoImpl;
import cn.hysoft.factory.BeanFactory;
import cn.hysoft.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

//    IAccountDao accountDao = new AccountDaoImpl();
    IAccountDao accountDao = (IAccountDao)BeanFactory.getBean("accountDao");
    public void saveAccount() {
        Integer i =1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
