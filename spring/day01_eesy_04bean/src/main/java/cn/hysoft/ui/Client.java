package cn.hysoft.ui;

import cn.hysoft.dao.IAccountDao;
import cn.hysoft.service.IAccountService;
import cn.hysoft.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Client {
    /**
     * 获取spring的IOC核心容器，并根据ID获取对象
     * @param args
     */
    public static void main(String[] args) {
        //获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as = (IAccountService)ac.getBean("accountService");
            as.saveAccount();
    }
}
