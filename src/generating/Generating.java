package generating;


import entity.creature.Creature;
import entity.creature.animal.Animal;
import entity.creature.animal.herbivore.Rabbit;
import entity.creature.animal.predator.Snake;
import entity.creature.animal.predator.Wolf;
import entity.creature.plant.Plant;
import settings.Settings;

import java.lang.reflect.Array;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

public class Generating {

    public static List<Animal> getAnimals() {
        return animals;
    }

    public static List<Plant> getPlants() {
        return plants;
    }

    private static final List<Animal> animals = new CopyOnWriteArrayList<>();

    private static final List<Plant> plants = new CopyOnWriteArrayList<>();

    public static void generateBiot() {

        for (int i = 0; i < rnd(Settings.wolfMaxNumber); i++) animals.add(new Wolf());
        for (int i = 0; i < rnd(Settings.snakeMaxNumber); i++) animals.add(new Snake());
        for (int i = 0; i < rnd(Settings.rabbitMaxNumber); i++) animals.add(new Rabbit());

        for (int i = 0; i < rnd(Settings.plantMaxNumber); i++) plants.add(new Plant());
    }

    public static int rnd(int max) {
        return (int) (Math.random() * ++max);
    }
}
