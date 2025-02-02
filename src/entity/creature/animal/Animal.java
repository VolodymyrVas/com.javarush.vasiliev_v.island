package entity.creature.animal;

import entity.Location;
import entity.creature.Creature;
import entity.creature.plant.Plant;
import settings.Settings;
import java.util.Random;

public abstract class Animal extends Creature {

    protected int weight;      // Вес животного
    protected int speed;       // Скорость перемещения (клеток за такт)
    protected int saturation;  // Сытость (если 0 → смерть)
    protected int maxSaturation; // Максимальная сытость

    private static final Random random = new Random();

    // ✅ Метод передвижения
    public void move(Location currentLocation, Location[][] island) {
        int x = random.nextInt(-speed, speed + 1);
        int y = random.nextInt(-speed, speed + 1);

        int newX = Math.max(0, Math.min(Settings.columnsCount - 1, x));
        int newY = Math.max(0, Math.min(Settings.rowsCount - 1, y));

        Location newLocation = island[newX][newY];

        if (newLocation.addAnimal(this)) {
            currentLocation.removeAnimal(this);
        }
    }

    // ✅ Метод поедания (травоядные → растения, хищники → животные)
//    public void eat(Creature food) {
//        if (food instanceof Plant) {
//            saturation = Math.min(maxSaturation, saturation + 10); // Например, растение восстанавливает 10
//        } else if (food instanceof Animal prey) {
//            int chance = Settings.getEatingChance(this.getClass(), prey.getClass());
//            if (random.nextInt(100) < chance) {
//                saturation = Math.min(maxSaturation, saturation + prey.weight);
//                prey.die();
//            }
//        }
//    }

    // ✅ Размножение (если есть пара)
    public Animal reproduce(Location location) {
        long count = location.getAnimalCount(this.getClass());
        if (count >= 2) {
            try {
                return this.getClass().getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    // ✅ Уменьшение сытости (если 0 → смерть)
    public void decreaseSaturation() {
        saturation--;
        if (saturation <= 0) {
            die();
        }
    }

    // ✅ Метод смерти (удаляет животное из Location)
    public void die() {
        System.out.println(this.getClass().getSimpleName() + " умер от голода или был съеден.");
    }
}
