/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoeStore.dao;

import com.shoeStore.model.Category;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class CategoryDao {
    public List<Category> getAllCategory(){
        List<Category> categorys = new ArrayList<Category>();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select * from category";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                Category category = new Category();
                category.setCid(rs.getInt("cid"));
                category.setCname(rs.getString("cname"));
                categorys.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categorys;
    }
}
