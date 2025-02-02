package statistic;

import entity.Location;
import entity.creature.animal.Animal;
import entity.creature.animal.herbivore.Rabbit;
import entity.creature.animal.predator.*;
import generating.Generating;
import java.util.List;
import java.util.Objects;

public class Statistic {

    public static void printStat() {
        long numberOfWolfs = Location.getAnimalsOnCell().stream().filter(a -> a instanceof Wolf).count();
        long numberOfSnake = Location.getAnimalsOnCell().stream().filter(a -> a instanceof Snake).count();
        long numberOfRabbit = Location.getAnimalsOnCell().stream().filter(a -> a instanceof Rabbit).count();

        long numberOfPlants = Location.getPlantsOnCell().stream().filter(Objects::nonNull).count();
        System.out.println("\u001B[31m" + "Predatory animals:" + "\u001B[0m");
        System.out.println("Wolfs -> " + numberOfWolfs);
        System.out.println("Snakes -> " + numberOfSnake);

        System.out.println("\u001B[31m" + "Herbivores:" + "\u001B[0m");
        System.out.println("Rabbit -> " + numberOfRabbit);

        System.out.println("\u001B[31m" + "Vegetation:" + "\u001B[0m");
        System.out.println("Plants -> " + numberOfPlants);
    }

//    public static long countOfAnimals(List<Animal> a, Animal animal) {
//        return a.stream()
//                .filter(x -> x.getClass().equals(animal.getClass())) // Сравниваем классы
//                .count();
//    }


//    public static void printCountOfAnimals() {
//        long countOfWolfs = countOfAnimals(Location.getAnimalsOnCell(), new Wolf());
//        long countOfSnakes = countOfAnimals(Location.getAnimalsOnCell(), new Snake());
//        long countOfRabbit = countOfAnimals(Location.getAnimalsOnCell(), new Rabbit());
//
//        System.out.println("countOfWolfs -> " + countOfWolfs);
//        System.out.println("countOfSnakes -> " + countOfSnakes);
//        System.out.println("countOfRabbit -> " + countOfRabbit);
//    }

//    public static void printCountOfPlants() {
//        long count = Location.getPlantsOnCell().size();
//        System.out.println("countOfPlants -> " + count);
//    }
}
