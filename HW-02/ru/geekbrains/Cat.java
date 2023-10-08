package ru.geekbrains;

public class Cat extends Alive implements Athletics {
    boolean isActive;

    public Cat(int maxLength, int maxHeight) {
        super(maxLength, maxHeight);
        this.isActive = true;
    }

    @Override
    public void run(int length) {
        if (isActive) {
            System.out.printf("Cat %s run %d\n", super.maxLength < length ? "not" : "", length);
        }
        if (super.maxLength < length)
            isActive = false;
    }

    @Override
    public void jump(int height) {
        if (isActive) {
            System.out.printf("Cat %s jump %d\n", super.maxHeight < height ? "not" : "", height);
        }
        if (super.maxHeight < height)
            isActive = false;
    }
}
