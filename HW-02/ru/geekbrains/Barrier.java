package ru.geekbrains;

public class Barrier implements Distance {

    private final int height;

    public Barrier(int height) {
        this.height = height;
    }

    @Override
    public void cross(Athletics athlete) {
        athlete.jump(height);
    }
}
