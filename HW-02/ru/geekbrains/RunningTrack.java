package ru.geekbrains;

public class RunningTrack implements Distance {

    private final int length;

    public RunningTrack(int length) {
        this.length = length;
    }

    @Override
    public void cross(Athletics athlete) {
        athlete.run(length);
    }
}
