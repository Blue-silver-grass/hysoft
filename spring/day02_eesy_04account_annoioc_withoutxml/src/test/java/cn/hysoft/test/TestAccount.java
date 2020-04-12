package cn.hysoft.test;

import cn.hysoft.domain.Account;
import cn.hysoft.service.IAccoutService;
import config.SpringConfigration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfigration.class)
public class TestAccount {
    @Autowired
    private IAccoutService accoutService;
    @Test
    public void testFindAll(){

//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfigration.class);
        try {
            List<Account> accounts = accoutService.findAllAccount();
            for (Account account : accounts){
                System.out.println(account);
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testFindOne(){

//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfigration.class);
        IAccoutService accoutService = ac.getBean("accountService",IAccoutService.class);
        Account account = accoutService.findAccountById(1);
        System.out.println(account);
    }


    @Test
    public void testSaveAccount(){
        Account account = new Account();
        account.setName("test");
        account.setMoney(12345f);

//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfigration.class);
        IAccoutService accoutService = ac.getBean("accountService",IAccoutService.class);
        accoutService.saveAccount(account);
    }


    @Test
    public void testUpdateAccount(){

//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfigration.class);
        IAccoutService accoutService = ac.getBean("accountService",IAccoutService.class);
        Account account = accoutService.findAccountById(4);
        account.setMoney(23456f);
        accoutService.updateAccount(account);
    }

    @Test
    public void testDeleteAccount(){

//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfigration.class);
        IAccoutService accoutService = ac.getBean("accountService",IAccoutService.class);
       accoutService.deleteAccount(4);
    }
}
