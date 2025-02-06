package entity;

import entity.creature.animal.Animal;
import entity.creature.animal.predator.Predator;
import entity.creature.plant.Plant;
import settings.Settings;

import java.util.List;
import java.util.Random;

public class AnimalEater {
    private final Random random = new Random();

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
                    break; // Один хищник может съесть только одну жертву за такт
                }
            }
        }
    }

    private void eatPlants(Animal herbivore, List<Plant> plants) {
        if (!plants.isEmpty()) {
            herbivore.increaseSaturation(5); // Например, каждая трава восстанавливает 5 единиц сытости
            plants.remove(0); // Удаляем одно растение
        }
    }
}

