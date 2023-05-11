package ru.geekbrains.task1;

public class Cat01  {

    private String name;
    private int appetite;
    private boolean satiety;

    public Cat01(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
    }
     
    public boolean getSatiety(){
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }   

    public String getName(){
        return name;
    }

    public int getAppetite(){
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }   
   
    public void eat() { 
        setSatiety(true);
    }

    public void info(boolean satiety) {
        if (satiety){
            System.out.printf("Кот %s сыт \n", name);
        }
        else {
            System.out.printf("Кот %s голоден \n" , name); 
        }
    }
}
