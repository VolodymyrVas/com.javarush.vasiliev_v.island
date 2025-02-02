package statistic;

import entity.creature.Creature;
import entity.creature.animal.Animal;
import entity.creature.animal.herbivore.Rabbit;
import entity.creature.animal.predator.*;
import entity.creature.plant.Plant;
import generating.Generating;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Statistic {
    public static long numberOfWolves = Generating.getAnimals().stream().filter(a -> a instanceof Wolf).count();
    static long numberOfSnake = Generating.getAnimals().stream().filter(a -> a instanceof Snake).count();
    static long numberOfRabbit = Generating.getAnimals().stream().filter(a -> a instanceof Rabbit).count();

    static long numberOfPlants = Generating.getPlants().stream().filter(Objects::nonNull).count();
    public static void printStat() {
        System.out.println("\u001B[31m" + "Predatory animals:" + "\u001B[0m");
        System.out.println("Wolfs -> " + numberOfWolves);
        System.out.println("Snakes -> " + numberOfSnake);

        System.out.println("\u001B[31m" + "Herbivores:" + "\u001B[0m");
        System.out.println("Rabbit -> " + numberOfRabbit);

        System.out.println("\u001B[31m" + "Vegetation:" + "\u001B[0m");
        System.out.println("Plants -> " + numberOfPlants);
    }

    public static long countOfAnimals(List<Animal> a, Animal animal) {
        return a.stream()
                .filter(x -> x.getClass().equals(animal.getClass())) // Сравниваем классы
                .count();
    }

    static long countOfWolfs = countOfAnimals(Generating.getAnimals(), new Wolf());
    static long countOfSnakes = countOfAnimals(Generating.getAnimals(), new Snake());
    static long countOfRabbit = countOfAnimals(Generating.getAnimals(), new Rabbit());
    public static void printCountOfAnimals() {
        System.out.println("countOfWolfs -> " + countOfWolfs);
        System.out.println("countOfSnakes -> " + countOfSnakes);
        System.out.println("countOfRabbit -> " + countOfRabbit);
    }

    public static void printCountOfPlants() {
        long count = Generating.getPlants().stream().count();
        System.out.println("countOfPlants -> " + count);
    }

}
