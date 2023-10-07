package ru.geekbrains;
import java.util.ArrayList;

class Product {
    private String name;
    private double price;
    private double rating;

    public Product(String name, double price, double rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return String.format("Наименование : %s ; цена : %.2f ; рейтинг : %.2f", name, price, rating);
    }
}
