package cn.hysoft.oracle;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;
import org.junit.Test;

import java.sql.*;

public class OracleDemo {
    @Test
    public void javaCallOracle() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "itheima", "itheima");
        PreparedStatement pstm = connection.prepareStatement("select * from emp where empno = ?");
        //给参数赋值
        pstm.setObject(1,7788);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString("ename"));
        }
        rs.close();
        pstm.close();
        connection.close();
    }

    @Test
    public void javaCallProcedure() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "itheima", "itheima");
        CallableStatement pstm = connection.prepareCall("{call p_yearsal(?,?)}");
        //给参数赋值
        pstm.setObject(1,7788);
        pstm.registerOutParameter(2, OracleTypes.NUMBER);
        pstm.execute();
        System.out.println(pstm.getObject(2));
        pstm.close();
        connection.close();
    }

    @Test
    public void javaCallFunction() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "itheima", "itheima");
        CallableStatement pstm = connection.prepareCall("{?=call f_yearsal(?)}");
        //给参数赋值
        pstm.setObject(2,7788);
        pstm.registerOutParameter(1, OracleTypes.NUMBER);
        pstm.execute();
        System.out.println(pstm.getObject(1));
        pstm.close();
        connection.close();
    }
}
