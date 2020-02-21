package com.gcsoft.dao;

import com.gcsoft.domain.Items;

import java.sql.SQLException;
import java.util.List;

public interface ItemDao {
    public List<Items> findAll() throws Exception;
}
