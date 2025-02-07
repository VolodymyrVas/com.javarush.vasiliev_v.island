package util;

import java.util.Random;

public enum Direction {
    UP(0, -1),
    RIGHT(1, 0),
    DOWN(0, 1),
    LEFT(-1, 0);

    private final int dx;
    private final int dy;
    private static final Random random = new Random();

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    // ✅ Метод для получения случайного направления
    public static Direction getRandomDirection() {
        Direction[] directions = values();
        return directions[random.nextInt(directions.length)];
    }
}

