package entity;

import entity.Island;
import entity.Location;
import entity.creature.animal.Animal;
import generating.Generating;
import settings.Settings;

public class AnimalReproducer implements Runnable {
    private final Island island;

    private Location location;

    public AnimalReproducer(Island island) {
        this.island = island;
    }

    @Override
    public void run() {
        for (Animal animal : location.getAnimals()) {
            Location location = findLocation(animal);
            if (location == null) continue;

            if (location.getAnimalCount(animal.getClass()) >= 2) {
                Animal baby = animal.reproduce(location);
                if (baby != null) {
                    location.addAnimal(baby);
                }
            }
        }
    }

    private Location findLocation(Animal animal) {
        for (int x = 0; x < Settings.columnsCount; x++) {
            for (int y = 0; y < Settings.rowsCount; y++) {
                Location location = island.getLocation(x, y);
                if (location.getAnimals().contains(animal)) {
                    return location;
                }
            }
        }
        return null;
    }
}

