package ru.geekbrains.task1;

import java.util.Scanner;

public class FeedingCats {
    public static void main(String[] args) {

        Cat01 [] cats = {
                new Cat01("Barsik", 5, false),
                new Cat01("Persik", 7, false),
                new Cat01("Murzik", 4, false),
                new Cat01("Aleks", 6, false),
                new Cat01("Feliks", 5, false)};

        Scanner iSc = new Scanner(System.in);
        Plate plate = new Plate(100);
        boolean fl = true;
        while (fl) {
            plate.info();
            System.out.println("Выберите действие : \n" +
                "- Покормить котов (1) \n" +
                "- Добавить корм в тарелку (2) \n" +
                "- Просмотр состояние сытости котов (3) \n" +
                "- Коты проголодались (4) \n" +
                "- Завершить программу (5)");
            char operation = iSc.nextLine().charAt(0);
            switch (operation) {
                case '1':
                    feeding(cats, plate);
                    break;
                case '2':
                    addFoodPlate(iSc, plate);
                    break;
                case '3':
                    stateSatiety(cats);
                    break;
                case '4':
                    catsAreHungry(cats);
                    break;
                case '5':
                    fl = false;
                    System.out.println("Завершение работы программы");
                    break;
                default:
                    System.err.println("Указан недопустимый оператор.");
                    break;
            }
        }
        iSc.close();
    }

    public static void feeding (Cat01 cats [], Plate plate) { 
        for (Cat01 cat : cats ){
            if (!cat.getSatiety()){
                if (plate.getFood() >= cat.getAppetite()){
                    cat.eat();
                    plate.setFood(plate.getFood() - cat.getAppetite());
                }
                else {
                    System.out.println("В тарелке недостаточно еды, добавить");
                    return;
                }
            }
        }
        System.out.println("Все коты сыты");
        return;
    }

    public static void addFoodPlate(Scanner iSc, Plate plate){
        System.out.println("Укажите, сколько еды добавить в тарелку: ");
        String value = iSc.nextLine();
        try { 
            int food = Integer.parseInt(value); 
            plate.setFood(plate.getFood() + food);
            return ; 
        } catch (NumberFormatException e) { 
            System.out.println("Входная строка не может быть преобразована в целое число."); 
        } 
    }

    public static void catsAreHungry (Cat01 cats []){
        for (Cat01 cat : cats ){
            cat.setSatiety(false);
            cat.info(cat.getSatiety());
        }
    }

    public static void stateSatiety (Cat01 cats []){
        for (Cat01 cat : cats ){
            cat.info(cat.getSatiety());
        }
    }
}    
    