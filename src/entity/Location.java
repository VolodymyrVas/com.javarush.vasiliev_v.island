package entity;

import entity.creature.animal.Animal;
import entity.creature.animal.predator.Wolf;
import generating.Generating;
import settings.Settings;
import java.util.Arrays;

public class Location {
    private static final Animal[] countOfWolfsOnСell = new Animal[Settings.wolfMaxNumber];

    public static long getWolfCount() {
        return Arrays.stream(countOfWolfsOnСell)
                .filter(animal -> animal instanceof Wolf)
                .count();
    }

    public static void printWolfsOnCell() {
        long count = getWolfCount();
        long totalWolves = Generating.getAnimals().stream()
                .filter(a -> a instanceof Wolf)
                .count();

        int freeSpace = (int) (countOfWolfsOnСell.length - count);
        System.out.println("Свободных мест для волков: " + freeSpace);

        if (freeSpace > 0) {
            int added = 0;
            for (int i = 0; i < countOfWolfsOnСell.length; i++) {
                if (countOfWolfsOnСell[i] == null && added < totalWolves) {
                    countOfWolfsOnСell[i] = new Wolf();
                    added++;
                }
            }
        }
    }

    public static void printArray() {
        for (int i = 0; i < countOfWolfsOnСell.length; i++) {
            System.out.println("i -> " + (i + 1) + " value -> " + countOfWolfsOnСell[i]);
        }
    }
}
