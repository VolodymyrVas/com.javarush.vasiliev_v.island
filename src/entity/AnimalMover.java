package entity;

import entity.creature.animal.Animal;
import util.Direction;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class AnimalMover implements Runnable {
    private final Island island;
    private static final Random random = new Random();

    public AnimalMover(Island island) {
        this.island = island;
    }

    @Override
    public void run() {
        for (int x = 0; x < island.getWidth(); x++) {
            for (int y = 0; y < island.getHeight(); y++) {
                Location location = island.getLocation(x, y);
                moveAnimals(location, x, y);
            }
        }
    }

    private void moveAnimals(Location location, int x, int y) {
        List<Animal> animals = new CopyOnWriteArrayList<>(location.getAnimals());

        for (Animal animal : animals) {
            Direction direction = Direction.getRandomDirection();
            int steps = animal.getSpeed();

            int newX = x + direction.getDx() * steps;
            int newY = y + direction.getDy() * steps;

            if (isValidMove(newX, newY)) {
                Location newLocation = island.getLocation(newX, newY);

                synchronized (newLocation) {
                    location.removeAnimal(animal);
                    newLocation.addAnimal(animal);
                }
            }
        }
    }

    private boolean isValidMove(int x, int y) {
        return x >= 0 && x < island.getWidth() && y >= 0 && y < island.getHeight();
    }
}
