package com.gcsoft.dao.impl;

import com.gcsoft.dao.ItemDao;
import com.gcsoft.domain.Items;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 要想从数据库中取出数据
 * 必须有四个属性：数据库驱动，连接数据库的地址，数据库用户名称，数据库密码
 */
public class ItemDaoImpl implements ItemDao {

    public List<Items> findAll() throws Exception {
        List<Items> list = new ArrayList<Items>();
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //先获取connection对象
            connection = DriverManager.getConnection("jdbc:mysql:///maven","root","root");
            //获取真正操作数据库的对象
            pst = connection.prepareCall("select * from items");
            //执行数据库操作
            rs = pst.executeQuery();
            //把数据库结果集转为Java list集合

            while (rs.next()){
                Items items = new Items();
                items.setId(rs.getInt("id"));
                items.setName(rs.getString("name"));
                list.add(items);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            connection.close();
            pst.close();
            rs.close();
        }
        return list;
    }
}
