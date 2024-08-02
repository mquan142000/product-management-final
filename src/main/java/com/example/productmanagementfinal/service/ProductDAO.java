package com.example.productmanagementfinal.service;

import com.example.productmanagementfinal.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductDAO implements IProduct {
    private String jdbcURL = "jdbc:mysql://localhost:3306/product";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345@abc";

    private static final String INSERT_PRODUCTS_SQL = "INSERT INTO product (nameProduct, price, quantity, color, category, description) VALUES (?,?,?,?,?,?);";
    private static final String SELECT_PRODUCT_BY_ID = "SELECT id, nameProduct, price, quantity, color, category, description FROM product WHERE id=?;";
    private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM product;";
    private static final String DELETE_PRODUCT_SQL = "DELETE FROM product WHERE id=?;";
    private static final String UPDATE_PRODUCT_SQL = "UPDATE product SET nameProduct=?, price=?, quantity=?, color=?, category=?, description=? WHERE id=?;";
    private static final String FIND_PRODUCTS_SQL = "SELECT * FROM product WHERE nameProduct LIKE? AND price LIKE? AND category LIKE? AND color LIKE?;";

    public ProductDAO() {

    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertProduct(Product product) throws SQLException {
        System.out.println(INSERT_PRODUCTS_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCTS_SQL)) {
            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getCategory());
            preparedStatement.setString(6, product.getDescription());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product selectProduct(int id) {
        Product product = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int productId = resultSet.getInt("id");
                String nameProduct = resultSet.getString("nameProduct");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String category = resultSet.getString("category");
                String description = resultSet.getString("description");

                product = new Product(productId, nameProduct, price, quantity, color, category, description);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public List<Product> selectAllProduct() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS)) {
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("id");
                String nameProduct = resultSet.getString("nameProduct");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String category = resultSet.getString("category");
                String description = resultSet.getString("description");

                products.add(new Product(productId, nameProduct, price, quantity, color, category, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_SQL)) {
            statement.setString(1, product.getNameProduct());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getColor());
            statement.setString(5, product.getCategory());
            statement.setString(6, product.getDescription());
            statement.setInt(7, product.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    @Override
    public List<Product> findProduct(String productName, double price, String category, String color) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(FIND_PRODUCTS_SQL)) {
            preparedStatement.setString(1, productName);
            preparedStatement.setDouble(2, price);
            preparedStatement.setString(3,  category);
            preparedStatement.setString(4, color);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("nameProduct");
                price = resultSet.getDouble("price");
                String colorProduct = resultSet.getString("color");
                String categoryProduct = resultSet.getString("category");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}

