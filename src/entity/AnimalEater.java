package entity;

import entity.creature.animal.Animal;
import entity.creature.plant.Plant;
import settings.Settings;

import java.util.Random;

public class AnimalEater implements Runnable {
    private final Island island;
    private final Random random = new Random();

    public AnimalEater(Island island) {
        this.island = island;
    }

    @Override
    public void run() {
        for (Animal predator : Location.getAnimalsOnCell()) {
            Location location = findLocation(predator);
            if (location == null) continue;

            for (Animal prey : Location.getAnimalsOnCell()) {
                if (predator != prey && random.nextInt(100) < Settings.getEatingChance(predator.getClass(), prey.getClass())) {
                    predator.eat(prey);
                    break; // Одного съели, больше не нужно
                }
            }

//            for (Plant plant : Location.getPlantsOnCell()) {
//                if (predator.eat(plant)) {
//                    location.getPlantsOnCell().remove(plant);
//                    break; // Одного съели, больше не нужно
//                }
//            }
        }
    }

    private Location findLocation(Animal animal) {
        for (int x = 0; x < Settings.columnsCount; x++) {
            for (int y = 0; y < Settings.rowsCount; y++) {
                Location location = island.getLocation(x, y);
                if (location.getAnimalsOnCell().contains(animal)) {
                    return location;
                }
            }
        }
        return null;
    }
}
