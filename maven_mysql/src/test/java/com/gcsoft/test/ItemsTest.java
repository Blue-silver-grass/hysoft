package com.gcsoft.test;

import com.gcsoft.dao.ItemDao;
import com.gcsoft.dao.impl.ItemDaoImpl;
import com.gcsoft.domain.Items;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ItemsTest {
    @Test
    public void findAll() throws Exception {
        ItemDao itemDao = new ItemDaoImpl();
        List<Items> list = itemDao.findAll();
        for (Items items : list){
            System.out.println(items.getName());
        }
    }
}
