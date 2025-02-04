package generating;

import entity.Island;
import entity.Location;
import entity.creature.animal.herbivore.Rabbit;
import entity.creature.animal.predator.Snake;
import entity.creature.animal.predator.Wolf;
import entity.creature.plant.Plant;
import settings.Settings;
import statistic.Statistic;
import java.util.Random;

public class Generating implements Runnable {
    private final Island island;
    private static final Random random = new Random();

    public Generating(Island island) {
        this.island = island;
    }

    public void generateBiot() {
        for (int i = 0; i < random.nextInt(Settings.wolfMaxNumber) + 1; i++) {
            getRandomLocation().addAnimal(new Wolf());
        }
        for (int i = 0; i < random.nextInt(Settings.snakeMaxNumber) + 1; i++) {
            getRandomLocation().addAnimal(new Snake());
        }
        for (int i = 0; i < random.nextInt(Settings.rabbitMaxNumber) + 1; i++) {
            getRandomLocation().addAnimal(new Rabbit());
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
        generateBiot();
        Statistic.printStat();
        System.out.println("#".repeat(77));
    }
}
