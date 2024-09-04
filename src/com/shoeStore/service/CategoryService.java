/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoeStore.service;

import com.shoeStore.dao.CategoryDao;
import com.shoeStore.model.Category;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CategoryService {
    CategoryDao categoryDao;
    
    public CategoryService(){
        categoryDao = new CategoryDao();
    }
    
    public List<Category> getAllCategory(){
        return categoryDao.getAllCategory();
    }
}
