package cn.hysoft.ui;

import cn.hysoft.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    /**
     * 获取spring的IOC核心容器，并根据ID获取对象
     *
     * @param args
     */
    public static void main(String[] args) {
        //获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        IAccountService as = (IAccountService) ac.getBean("accountService");
//        IAccountService as = (IAccountService) ac.getBean("accountService2");
        IAccountService as = (IAccountService) ac.getBean("accountService3");
        as.saveAccount();
    }
}
