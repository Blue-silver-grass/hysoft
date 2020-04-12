package cn.hysoft.utils;

import org.springframework.beans.factory.annotation.Autowired;

public class TransactionManager {
    @Autowired
    private ConnectionUtils connectionUtils;

    public ConnectionUtils setConnectionUtils() {
        return connectionUtils;
    }

    public void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void release(){
        try {
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeConnecton();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
