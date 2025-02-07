package statistic;

import entity.Island;
import entity.Location;
import entity.creature.animal.herbivore.*;
import entity.creature.animal.predator.*;



public class Statistic {

    private final Island island; //  Экземпляр острова для статистики

    public Statistic(Island island) {
        this.island = island;
    }

    public void printStat() {
        System.out.println("🔍 Debug: printStat() вызван!");
        long numberOfWolfs = 0;
        long numberOfSnakes = 0;
        long numberOfFoxes = 0;
        long numberOfEagles = 0;
        long numberOfBears = 0;

        long numberOfRabbits = 0;
        long numberOfSheep = 0;
        long numberOfMouses = 0;
        long numberOfHorses = 0;
        long numberOfGoats = 0;
        long numberOfDucks = 0;
        long numberOfDeer = 0;
        long numberOfCaterpillars = 0;
        long numberOfBuffalo = 0;
        long numberOfBoars = 0;

        long numberOfPlants = 0;

        // Проход по всему острову
        for (int x = 0; x < island.getWidth(); x++) {
            for (int y = 0; y < island.getHeight(); y++) {
                Location location = island.getLocation(x, y);
                numberOfWolfs += location.getAnimals().stream().filter(a -> a instanceof Wolf).count();
                numberOfSnakes += location.getAnimals().stream().filter(a -> a instanceof Snake).count();
                numberOfFoxes += location.getAnimals().stream().filter(a -> a instanceof Fox).count();
                numberOfEagles += location.getAnimals().stream().filter(a -> a instanceof Eagle).count();
                numberOfBears += location.getAnimals().stream().filter(a -> a instanceof Bear).count();

                numberOfRabbits += location.getAnimals().stream().filter(a -> a instanceof Rabbit).count();
                numberOfSheep += location.getAnimals().stream().filter(a -> a instanceof Sheep).count();
                numberOfMouses += location.getAnimals().stream().filter(a -> a instanceof Mouse).count();
                numberOfHorses += location.getAnimals().stream().filter(a -> a instanceof Horse).count();
                numberOfGoats += location.getAnimals().stream().filter(a -> a instanceof Goat).count();
                numberOfDucks += location.getAnimals().stream().filter(a -> a instanceof Duck).count();
                numberOfDeer += location.getAnimals().stream().filter(a -> a instanceof Deer).count();
                numberOfCaterpillars += location.getAnimals().stream().filter(a -> a instanceof Caterpillar).count();
                numberOfBuffalo += location.getAnimals().stream().filter(a -> a instanceof Buffalo).count();
                numberOfBoars += location.getAnimals().stream().filter(a -> a instanceof Boar).count();

                numberOfPlants += location.getPlants().size();
            }
        }

        // Вывод статистики в консоль
        System.out.println("\u001B[31m" + "Predatory animals:" + "\u001B[0m");
        System.out.println("Wolves -> " + numberOfWolfs);
        System.out.println("Snakes -> " + numberOfSnakes);
        System.out.println("Foxes -> " + numberOfFoxes);
        System.out.println("Eagles -> " + numberOfEagles);
        System.out.println("Bears -> " + numberOfBears);

        System.out.println("\u001B[32m" + "Herbivores:" + "\u001B[0m");
        System.out.println("Rabbits -> " + numberOfRabbits);
        System.out.println("Sheep -> " + numberOfSheep);
        System.out.println("Mouses -> " + numberOfMouses);
        System.out.println("Horses -> " + numberOfHorses);
        System.out.println("Goats -> " + numberOfGoats);
        System.out.println("Ducks -> " + numberOfDucks);
        System.out.println("Deer -> " + numberOfDeer);
        System.out.println("Caterpillars -> " + numberOfCaterpillars);
        System.out.println("Buffalo -> " + numberOfBuffalo);
        System.out.println("Boars -> " + numberOfBoars);

        System.out.println("\u001B[34m" + "Vegetation:" + "\u001B[0m");
        System.out.println("Plants -> " + numberOfPlants);
    }
}
