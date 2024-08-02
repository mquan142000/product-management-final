package com.example.productmanagementfinal.service;

import com.example.productmanagementfinal.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProduct {
    public void insertProduct(Product product) throws SQLException;

    public Product selectProduct(int id);

    public List<Product> selectAllProduct();

    public boolean deleteProduct(int id) throws SQLException;

    public boolean updateProduct(Product product) throws SQLException;

    public List<Product> findProduct (String productName , double price, String category, String color);
}
