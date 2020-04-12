package cn.hysoft.jdbctemplate;

import cn.hysoft.dao.IAccountDao;
import cn.hysoft.dao.impl.AccountDaoImpl;
import cn.hysoft.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateDemo4 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
//        jt.execute("insert into account(name,money) values ('eee',1000)");
        IAccountDao accountDao = ac.getBean("accountDao",IAccountDao.class);
        Account account = accountDao.findAccountById(1);
        System.out.println(account);
        account.setMoney(10000f);
        accountDao.update(account);
        /*
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/eesy");
        ds.setUsername("root");
        ds.setPassword("root");

        JdbcTemplate jt = new JdbcTemplate();
        jt.setDataSource(ds);
        jt.execute("insert into account(name,money) values ('ddd',1000)");
        */
    }
}
