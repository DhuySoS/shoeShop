/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoeStore.service;

import com.shoeStore.dao.ShoeDao;
import com.shoeStore.model.Shoe;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class ShoeService {
    ShoeDao shoeDao;

    public ShoeService() {
        shoeDao = new ShoeDao();
    }
        
    public List<Shoe> getAllShoes(){
        return shoeDao.getAllShoes();
    }
    
    public String getCateFromProduct(Shoe shoe){
        return shoeDao.getCateFromProduct(shoe);
    }
    public ImageIcon fitSize(Shoe shoe, JLabel label){
        ImageIcon scaleIcon = null;
        try {
            URL url = new URL(shoe.getImage());
            ImageIcon imageIcon = new ImageIcon(url);
            Image image = imageIcon.getImage();
            Image imageScale = image.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
            scaleIcon = new ImageIcon(imageScale);
        } catch (MalformedURLException  e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace(); 
    }
        return scaleIcon;
    }
    
    public List<Shoe> getProductFromCate(int cateId){
        return shoeDao.getProductFromCate(cateId);
    }
}
