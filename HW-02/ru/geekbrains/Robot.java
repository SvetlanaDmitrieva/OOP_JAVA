package ru.geekbrains;

public class Robot extends Creature implements Athletics {

    boolean isActive;

    public Robot(int maxLength, int maxHeight) {
        super(maxLength, maxHeight);
        this.isActive = true;
    }

    @Override
    public void run(int length) {
        if (isActive) {
            System.out.printf("Robot %s run %d\n", super.maxLength < length ? "not" : "", length);
        }
        if (super.maxLength < length)
            isActive = false;
    }

    @Override
    public void jump(int height) {
        if (isActive) {
            System.out.printf("Robot %s jump %d\n", super.maxHeight < height ? "not" : "", height);
        }
        if (super.maxHeight < height)
            isActive = false;
    }
}
