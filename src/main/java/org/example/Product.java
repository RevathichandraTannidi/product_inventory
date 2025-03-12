package org.example;

import java.util.Optional;

public class Product {
    private int id;
    public String name;
    public String category;
    public double price;
    public double stock_quantity;
    Optional<Double> rating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(double stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public Optional<Double> getRating() {
        return rating;
    }

    public void setRating(Optional<Double> rating) {
        this.rating = rating;
    }

    public Product(int id, String name, String category, double price, double stock_quantity, Optional<Double> rating) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock_quantity = stock_quantity;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", stock_quantity=" + stock_quantity +
                ", rating=" + rating .orElse(3.0)+
                '}';
    }
}
