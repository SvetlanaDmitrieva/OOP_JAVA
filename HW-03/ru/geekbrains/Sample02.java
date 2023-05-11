package ru.geekbrains;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Sample02 {

    private static Random random = new Random();

    /**
     * TODO: 2. generateEmployee должен создавать различных сотрудников (Worker, Freelancer)
     * @return
     */
    static Employee generateEmployee(){
        String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
        String[] surnames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };
       
        int typeEmployee = random.nextInt(1, 4);
        double salary = random.nextDouble(200., 300.);
        int index = random.nextInt(30, 50);
        int age = random.nextInt(18,85);
        
        Employee employee = (typeEmployee == 1) ? new Worker(names[random.nextInt(10)], surnames[random.nextInt(10)], age, salary * index):
                    (typeEmployee == 2) ? new Manager(names[random.nextInt(10)], surnames[random.nextInt(10)], age, (salary * index / 20. /8)):
                    new Freelancer(names[random.nextInt(10)], surnames[random.nextInt(10)], age,(salary * index / 20. / 8));

        return employee ;
    }

    public static void main(String[] args) {
        
        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++)
            employees[i] = generateEmployee();

        for (Employee employee : employees){
            System.out.println(employee);
        }

        Arrays.sort(employees);

        System.out.printf("\n*** Отсортированный массив сотрудников по зарплате ***\n\n");

        for (Employee employee : employees){
            System.out.println(employee);
        }

        Arrays.sort(employees, new AgeComparator());

        System.out.printf("\n*** Отсортированный массив сотрудников по возрасту***\n\n");

        for (Employee employee : employees){
            System.out.println(employee);
        }
    }
}

class SalaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {

        return Double.compare( o2.calculateSalary(), o1.calculateSalary());
    }
}

class NameComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
    
        int res = o1.name.compareTo(o2.name);
        if (res == 0){
            res = Double.compare( o2.calculateSalary(), o1.calculateSalary());
        }
        return res;
    }
}

class AgeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
    
        int res = o2.age - o1.age;
        if (res == 0){
            res = o1.surName.compareTo(o2.surName);
        }  
        if (res == 0){
            res = o1.name.compareTo(o2.name);
        }  
        if (res == 0){
            res = Double.compare( o2.calculateSalary(), o1.calculateSalary());
        }
        return res;
    }
}

abstract class Employee implements Comparable<Employee>{

    protected String name;
    protected String surName;
    protected int age;
    protected double salary;
   

    public Employee(String name, String surName, int age, double salary) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.salary = salary;
    }

    public abstract  double calculateSalary();

    @Override
    public String toString() {
        return String.format("Сотрудник: %s %s; Возраст: %d ; Среднемесячная заработная плата: %.2f", name, surName, age, salary);
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare( o.calculateSalary(), calculateSalary());
    }
}

class Worker extends Employee{

    public Worker(String name, String surName, int age, double salary) {
        super(name, surName, age, salary);
    }

    @Override
    public double calculateSalary() {
        return salary ;
        //TODO: Для фрилансера - return 20 * 5 * salary
    }

    @Override
    public String toString() {
        return String.format("Рабочий: %s %s; Возраст: %d ; Среднемесячная зарплата (фиксированная месячная оплата): %.2f (руб.)", name, surName, age, calculateSalary());
    }
}

/**
 * TODO: 1. Доработать самостоятельно в рамках домашней работы
 */
class Freelancer extends Employee{

    public Freelancer(String name, String surName, int age, double salary) {
        super(name, surName, age, salary);
    }

    @Override
    public double calculateSalary() {
        return 20. * 5 * salary;
    }
    @Override
    public String toString() {
        return String.format("Фрилансер (неполный раб. день): %s %s; Возраст: %d ; Среднемесячная зарплата (рабочий день - 5 часов): %.2f (руб.)", name, surName, age, calculateSalary());
    }
} 

class Manager extends Employee{

    public Manager(String name, String surName, int age, double salary ) {
        super(name, surName, age, salary);
    }
    
    @Override
    public double calculateSalary() {
        return 20. * 8 * salary;
    }
    @Override
    public String toString() {
        return String.format("Менеджер : %s %s; Возраст: %d ; Среднемесячная зарплата (рабочий день - 8 часов): %.2f (руб.)", name, surName, age, calculateSalary());
     }
}
