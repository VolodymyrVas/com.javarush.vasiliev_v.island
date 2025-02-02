package generating;

import entity.creature.animal.Animal;
import entity.creature.animal.herbivore.Rabbit;
import entity.creature.animal.predator.Snake;
import entity.creature.animal.predator.Wolf;
import entity.creature.plant.Plant;
import settings.Settings;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;


public class Generating implements Runnable {

    public static List<Animal> getAnimals() {
        return animals;
    }

    public static List<Plant> getPlants() {
        return plants;
    }

    private static final List<Animal> animals = new CopyOnWriteArrayList<>();

    private static final List<Plant> plants = new CopyOnWriteArrayList<>();

    public static void generateBiot() {
        Random random = new Random();
        animals.clear();
        plants.clear();
        for (int i = 0; i < random.nextInt(Settings.wolfMaxNumber) + 1; i++) animals.add(new Wolf());
        for (int i = 0; i < random.nextInt(Settings.snakeMaxNumber) + 1; i++) animals.add(new Snake());
        for (int i = 0; i < random.nextInt(Settings.rabbitMaxNumber) + 1; i++) animals.add(new Rabbit());

        for (int i = 0; i < random.nextInt(Settings.plantMaxNumber) + 1; i++) plants.add(new Plant());
    }

    @Override
    public void run() {

    }
}
