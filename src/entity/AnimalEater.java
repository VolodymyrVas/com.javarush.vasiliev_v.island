package entity;

import entity.creature.animal.Animal;
import entity.creature.animal.predator.Predator;
import entity.creature.plant.Plant;
import settings.Settings;

import java.util.List;
import java.util.Random;

public class AnimalEater implements Runnable { // ✅ Теперь `Runnable`
    private final Island island;
    private final Random random = new Random();

    public AnimalEater(Island island) {
        this.island = island;
    }

    @Override
    public void run() {
        for (int x = 0; x < island.getWidth(); x++) {
            for (int y = 0; y < island.getHeight(); y++) {
                Location location = island.getLocation(x, y);
                processEating(location);
            }
        }
    }

    public void processEating(Location location) {
        List<Animal> animals = location.getAnimals();
        List<Plant> plants = location.getPlants();

        for (Animal animal : animals) {
            if (animal instanceof Predator) {
                eatOtherAnimals(animal, location);
            } else {
                eatPlants(animal, plants);
            }
        }
    }

    private void eatOtherAnimals(Animal predator, Location location) {
        List<Animal> potentialPrey = location.getAnimals();
        for (Animal prey : potentialPrey) {
            if (predator.getClass() != prey.getClass()) {
                int chance = Settings.getEatingChance(predator.getClass(), prey.getClass());
                if (random.nextInt(100) < chance) {
                    predator.increaseSaturation(prey.getWeight());
                    location.removeAnimal(prey);
//                    System.out.println(predator.getClass().getSimpleName() + " съел " + prey.getClass().getSimpleName() + " в клетке [" + location + "]");
                    break; // Один хищник ест одну жертву за такт
                }
            }
        }
    }

    private void eatPlants(Animal herbivore, List<Plant> plants) {
        if (!plants.isEmpty()) {
            herbivore.increaseSaturation(5);
            plants.remove(0);
//            System.out.println(herbivore.getClass().getSimpleName() + " съел растение в клетке");
        }
    }
}
