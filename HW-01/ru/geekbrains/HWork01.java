package ru.geekbrains;

import java.util.ArrayList;

public class HWork01 {
    public static void main(String[] args) {
        // созданы две категории товаров, добавлено по 3 товара в кажд. категорию
        Category category1 = new Category("Category 1");
        category1.addProducts(new Product("Product 1", 10.99, 4.5));
        category1.addProducts(new Product("Product 2", 5.99, 3.5));
        category1.addProducts(new Product("Product 3", 12.99, 5.5));

        Category category2 = new Category("Category 2");
        category2.addProducts(new Product("Product 4", 20.99, 3.5));
        category2.addProducts(new Product("Product 5", 15.99, 5.5));
        category2.addProducts(new Product("Product 6", 32.99, 4.5));

        Category[] Categorys = new Category[] { category1, category2 };
        System.out.println(" Товары до покупки");
        for (Category category : Categorys) { // вывод на печать всех имеющихся товароа
            System.out.println(category.getName()); // по категориям
            ArrayList<Product> products = category.getProducts();
            for (Product product : products) {
                System.out.println(product);
            }
        }
        User user1 = new User("user1", "password1"); // создано 2 пользователя
        user1.getBasket().addProducts(category1.getProducts().get(0)); // внесено по 2 товара
        user1.getBasket().addProducts(category2.getProducts().get(0)); // в корзины каждому пользователю

        category1.getProducts().remove(0); // удалены из магазина товары, внесенные в корзины
        category2.getProducts().remove(0);

        User user2 = new User("user2", "password2");
        user2.getBasket().addProducts(category1.getProducts().get(1));
        user2.getBasket().addProducts(category2.getProducts().get(1));

        category1.getProducts().remove(1);
        category2.getProducts().remove(1);

        User[] Users = new User[] { user1, user2 };

        for (User user : Users) { // вывод на печать содержимое корзин пользователей
            System.out.println(user.getLogin());
            ArrayList<Product> userProducts = user.getBasket().getProducts();
            for (Product product : userProducts) {
                System.out.println(product);
            }
        }

        System.out.println(" Товары после покупки(остаток)");
        for (Category category : Categorys) { // вывод на печать всех оставшихся товаров
            System.out.println(category.getName());
            ArrayList<Product> products = category.getProducts();
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }
}
