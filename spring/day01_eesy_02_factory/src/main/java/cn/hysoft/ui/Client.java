package cn.hysoft.ui;

import cn.hysoft.dao.IAccountDao;
import cn.hysoft.factory.BeanFactory;
import cn.hysoft.service.IAccountService;
import cn.hysoft.service.impl.AccountServiceImpl;

public class Client {
    public static void main(String[] args) {
//        IAccountService accountService = new AccountServiceImpl();
//        accountService.saveAccount();
        for (int i=0;i<5;i++) {
            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }
    }
}
