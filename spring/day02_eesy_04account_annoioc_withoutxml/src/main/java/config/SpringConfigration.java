package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

//@Configuration
@ComponentScan("cn.hysoft")
@Import({JdbcConfig.class,cn.hysoft.utils.ConnectionUtils.class,cn.hysoft.utils.TransactionManager.class})
@PropertySource("classpath:JdbcConfig.properties")
public class SpringConfigration {
//    @Bean("runner")
//    @Scope("prototype")
//    public QueryRunner createQueryRunner(DataSource datasource) {
//        return new QueryRunner(datasource);
//    }
//
//    @Bean(name = "datasource")
//    public DataSource createDatasource() {
//        ComboPooledDataSource ds = new ComboPooledDataSource();
//        try {
//            ds.setDriverClass("com.mysql.jdbc.Driver");
//            ds.setJdbcUrl("jdbc:mysql://localhost:3306/eesy_spring");
//            ds.setUser("root");
//            ds.setPassword("root");
//            return ds;
//        } catch (PropertyVetoException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }
}
