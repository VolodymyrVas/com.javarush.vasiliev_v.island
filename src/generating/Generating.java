package generating;

import entity.Location;
import entity.creature.animal.herbivore.Rabbit;
import entity.creature.animal.predator.Snake;
import entity.creature.animal.predator.Wolf;
import entity.creature.plant.Plant;
import settings.Settings;
import statistic.Statistic;
import java.util.Random;





public class Generating implements Runnable {

    public static void generateBiot() {
        Random random = new Random();
        for (int i = 0; i < random.nextInt(Settings.wolfMaxNumber) + 1; i++) Location.getAnimalsOnCell().add(new Wolf());
        for (int i = 0; i < random.nextInt(Settings.snakeMaxNumber) + 1; i++) Location.getAnimalsOnCell().add(new Snake());
        for (int i = 0; i < random.nextInt(Settings.rabbitMaxNumber) + 1; i++) Location.getAnimalsOnCell().add(new Rabbit());

        for (int i = 0; i < random.nextInt(Settings.plantMaxNumber) + 1; i++) Location.getPlantsOnCell().add(new Plant());
    }

    @Override
    public void run() {
        System.out.println("run proces");
        System.out.println("#".repeat(77));

    }
}
