package cn.hysoft.utils;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;

public class ConnectionUtils {
    private ThreadLocal<Connection> t1 = new ThreadLocal<Connection>();
    @Autowired
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getThreadConnection(){
        Connection conn = t1.get();
        try{
            if (conn==null){
                conn = dataSource.getConnection();
                t1.set(conn);
            }
            return conn;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }


    public void removeConnecton(){
        t1.remove();
    }
}
