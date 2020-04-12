package cn.hysoft.test;

import config.SpringConfigration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class QueryRunnerTest {
    @Test
    public void testQueryRunner(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfigration.class);
        QueryRunner runner = ac.getBean("runner", QueryRunner.class);
        QueryRunner runner1 = ac.getBean("runner", QueryRunner.class);
        System.out.println(runner==runner1);
    }
}
