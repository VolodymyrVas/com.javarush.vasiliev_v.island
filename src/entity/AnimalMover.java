package entity;

import entity.Island;
import entity.Location;
import entity.creature.animal.Animal;
import settings.Settings;
import util.Direction;
import java.util.Random;

public class AnimalMover implements Runnable {
    private final Island island;
    private static final Random random = new Random();

    public AnimalMover(Island island) {
        this.island = island;
    }

    @Override
    public void run() {
        for (int x = 0; x < Settings.columnsCount; x++) {
            for (int y = 0; y < Settings.rowsCount; y++) {
                Location location = island.getLocation(x, y);
                for (Animal animal : Location.getAnimalsOnCell()) {
                    moveAnimal(animal, location);
                }
            }
        }
    }

    private void moveAnimal(Animal animal, Location currentLocation) {
        Direction direction = Direction.values()[random.nextInt(Direction.values().length)];
        int newX = currentLocation.getX();
        int newY = currentLocation.getY();

        switch (direction) {
            case UP -> newY -= animal.getSpeed();
            case DOWN -> newY += animal.getSpeed();
            case LEFT -> newX -= animal.getSpeed();
            case RIGHT -> newX += animal.getSpeed();
        }

        if (newX >= 0 && newX < Settings.columnsCount && newY >= 0 && newY < Settings.rowsCount) {
            Location newLocation = island.getLocation(newX, newY);
            if (newLocation.addAnimal(animal)) {
                currentLocation.removeAnimal(animal);
            }
        }
    }
}
