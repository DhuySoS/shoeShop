/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoeStore.dao;

import com.shoeStore.model.Shoe;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;


public class ShoeDao {
    public List<Shoe> getAllShoes(){
        List<Shoe> shoes = new ArrayList<Shoe>();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select * from product";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                Shoe shoe = new Shoe();
                shoe.setId(rs.getInt("id"));
                shoe.setName(rs.getString("name"));
                shoe.setImage(rs.getString("image"));
                shoe.setPrice(rs.getDouble("price"));
                shoe.setTitle(rs.getString("title"));
                shoe.setDescription(rs.getString("description"));
                shoe.setCateID(rs.getInt("cateID"));
                shoe.setSell_ID(rs.getInt("sell_ID"));
                
                shoes.add(shoe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoes;
    }
    
    public String getCateFromProduct(Shoe shoe){
        int cateId = shoe.getCateID();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "SELECT category.cname FROM product INNER JOIN category ON category.cid= "+cateId;
        String cateName = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) { // Di chuyển đến dòng đầu tiên
                cateName = rs.getString("cname");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cateName;
    }
    public List<Shoe> getProductFromCate(int cateId){
        List<Shoe> shoes = new ArrayList<Shoe>();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * from product INNER JOIN category on category.cid = product.cateID WHERE category.cid = "+ cateId;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Shoe shoe = new Shoe();
                shoe.setId(rs.getInt("id"));
                shoe.setName(rs.getString("name"));
                shoe.setImage(rs.getString("image"));
                shoe.setPrice(rs.getDouble("price"));
                shoe.setTitle(rs.getString("title"));
                shoe.setDescription(rs.getString("description"));
                shoe.setCateID(rs.getInt("cateID"));
                shoe.setSell_ID(rs.getInt("sell_ID"));
                
                shoes.add(shoe);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shoes;
    }
}
