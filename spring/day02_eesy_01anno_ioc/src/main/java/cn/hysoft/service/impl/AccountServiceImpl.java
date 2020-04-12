package cn.hysoft.service.impl;

import cn.hysoft.dao.IAccountDao;
import cn.hysoft.dao.impl.AccountDaoImpl;
import cn.hysoft.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 账户的业务层实现类
 * <bean id="accountService" class="cn.hysoft.service.impl.AccountServiceImpl"></bean>
 */
@Component
public class AccountServiceImpl implements IAccountService {
    @Autowired
    IAccountDao accountDao;
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
