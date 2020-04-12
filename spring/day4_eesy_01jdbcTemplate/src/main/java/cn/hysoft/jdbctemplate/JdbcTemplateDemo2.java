package cn.hysoft.jdbctemplate;

import cn.hysoft.dao.IAccountDao;
import cn.hysoft.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTemplateDemo2 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        jt.execute("insert into account(name,money )values ('ffff',222)");

//        jt.update("insert into account (name,money) values (?,?)","fff",3333f);

//        jt.update("update account set name=?,money=? where id=?","test",9999f,4);
//        jt.update("delete from account where id=?",6);

//        List<Account> accounts = jt.query("select * from account where money>?",
//                new BeanPropertyRowMapper<Account>(Account.class), 1000f);
//        for (Account account:accounts){
//            System.out.println(account);
//        }

        Long l = jt.queryForObject("select count(*) from account where money>?", Long.class, 1000f);
        System.out.println(l);
    }


}

//class AccountRowMapper implements RowMapper<Account>{
//    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Account account = new Account();
//        account.setId(rs.getInt("id"));
//        account.setName(rs.getString("name"));
//        account.setMoney(rs.getFloat("money"));
//        return account;
//    }
//}
