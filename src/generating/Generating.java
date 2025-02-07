package generating;

import entity.Island;
import entity.Location;
import entity.creature.animal.herbivore.*;
import entity.creature.animal.predator.*;
import entity.creature.plant.Plant;
import settings.Settings;
import statistic.Statistic;
import java.util.Random;

public class Generating implements Runnable {
    private final Island island;
    private final Statistic statistic;

    private static final Random random = new Random();

    public Generating(Island island) {
        this.island = island;
        this.statistic = new Statistic(island);
    }

    public void generateBiot() {
        for (int i = 0; i < random.nextInt(Settings.wolfMaxNumber) + 1; i++) {
            getRandomLocation().addAnimal(new Wolf());
        }
        for (int i = 0; i < random.nextInt(Settings.snakeMaxNumber) + 1; i++) {
            getRandomLocation().addAnimal(new Snake());
        }
        for (int i = 0; i < random.nextInt(Settings.foxMaxNumber) + 1; i++) {
            getRandomLocation().addAnimal(new Fox());
        }
        for (int i = 0; i < random.nextInt(Settings.eagleMaxNumber) + 1; i++) {
            getRandomLocation().addAnimal(new Eagle());
        }
        for (int i = 0; i < random.nextInt(Settings.bearMaxNumber) + 1; i++) {
            getRandomLocation().addAnimal(new Bear());
        }

        for (int i = 0; i < random.nextInt(Settings.rabbitMaxNumber) + 1; i++) {
            getRandomLocation().addAnimal(new Rabbit());
        }
        for (int i = 0; i < random.nextInt(Settings.sheepMaxNumber) + 1; i++) {
            getRandomLocation().addAnimal(new Sheep());
        }
        for (int i = 0; i < random.nextInt(Settings.horseMaxNumber) + 1; i++) {
            getRandomLocation().addAnimal(new Horse());
        }
        for (int i = 0; i < random.nextInt(Settings.goatMaxNumber) + 1; i++) {
            getRandomLocation().addAnimal(new Goat());
        }
        for (int i = 0; i < random.nextInt(Settings.duckMaxNumber) + 1; i++) {
            getRandomLocation().addAnimal(new Duck());
        }
        for (int i = 0; i < random.nextInt(Settings.deerMaxNumber) + 1; i++) {
            getRandomLocation().addAnimal(new Deer());
        }
        for (int i = 0; i < random.nextInt(Settings.buffaloMaxNumber) + 1; i++) {
            getRandomLocation().addAnimal(new Buffalo());
        }
        for (int i = 0; i < random.nextInt(Settings.caterpillarMaxNumber) + 1; i++) {
            getRandomLocation().addAnimal(new Caterpillar());
        }
        for (int i = 0; i < random.nextInt(Settings.boarMaxNumber) + 1; i++) {
            getRandomLocation().addAnimal(new Boar());
        }
        for (int i = 0; i < random.nextInt(Settings.mouseMaxNumber) + 1; i++) {
            getRandomLocation().addAnimal(new Mouse());
        }

        for (int i = 0; i < random.nextInt(Settings.plantMaxNumber) + 1; i++) {
            getRandomLocation().addPlant(new Plant());
        }
    }

    private Location getRandomLocation() {
        int x = random.nextInt(Settings.columnsCount);
        int y = random.nextInt(Settings.rowsCount);
        return island.getLocation(x, y);
    }

    @Override
    public void run() {
        statistic.printStat();
        System.out.println("#".repeat(77));
    }
}
