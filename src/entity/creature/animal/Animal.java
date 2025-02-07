package entity.creature.animal;

import entity.Island;
import entity.Location;
import entity.creature.Creature;
import entity.creature.plant.Plant;
import settings.Settings;
import util.Direction;

import java.util.Random;

public abstract class Animal extends Creature {

    protected int weight;      // Вес животного
    protected int speed;       // Скорость перемещения (клеток за такт)
    protected int saturation;  // Сытость (если 0 → смерть)
    protected int maxSaturation; // Максимальная сытость

    public int getSaturation() {
        return saturation;
    }
    public int getSpeed() {
        return speed;
    }

    public int getWeight() {
        return weight;
    }

    private static final Random random = new Random();

    // ✅ Метод передвижения
    public void move(Island island, Location currentLocation) {
        Direction direction = Direction.values()[random.nextInt(Direction.values().length)]; // Случайное направление

        int newX = currentLocation.getX();
        int newY = currentLocation.getY();

        // Определяем новую координату в зависимости от направления
        switch (direction) {
            case UP -> newY -= speed;
            case DOWN -> newY += speed;
            case LEFT -> newX -= speed;
            case RIGHT -> newX += speed;
        }

        // Проверяем, чтобы животное не вышло за границы острова
        if (newX < 0 || newX >= Settings.columnsCount || newY < 0 || newY >= Settings.rowsCount) {
            return; // Если выходит за границы — не двигаемся
        }

        Location newLocation = island.getLocation(newX, newY); // Получаем новую локацию

        if (newLocation.addAnimal(this)) { // Добавляем в новую клетку
            currentLocation.removeAnimal(this); // Удаляем из старой
        }
    }

    //     ✅ Метод поедания (травоядные → растения, хищники → животные)
    public void eat(Creature food) {
        int chance = Settings.getEatingChance(this.getClass(), food.getClass()); // Используем food
        if (random.nextInt(100) < chance) {
            saturation = Math.min(maxSaturation, saturation + ((Animal) food).weight); // Приведение к Animal
            ((Animal) food).die();
        }
    }


    // Размножение (если есть пара)
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

    // Метод смерти (удаляет животное из Location)
    public void die() {
        this.getClass().getSimpleName();
    }

    public void increaseSaturation(int amount) {
        this.saturation = Math.min(this.saturation + amount, this.maxSaturation);
    }

}
