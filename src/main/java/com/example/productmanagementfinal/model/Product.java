package com.example.productmanagementfinal.model;

public class Product {
    private int id;
    private String nameProduct;
    private double price;
    private int quantity;
    private String color;
    private String category;
    private String description;

    public Product(String name, double price, int quantity, String color, String category, String description) {
        super();
        this.nameProduct = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.category = category;
        this.description = description;
    }

    public Product(int id, String nameProduct, double price, int quantity, String color, String category, String description) {
        super();
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.category = category;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
