package entity;

import entity.creature.animal.Animal;
import entity.creature.animal.herbivore.*;
import entity.creature.animal.predator.*;
import settings.Settings;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AnimalLifeCycle implements Runnable {
    private final Island island;

    public AnimalLifeCycle(Island island) {
        this.island = island;
    }

    @Override
    public void run() {
        for (int x = 0; x < Settings.columnsCount; x++) {
            for (int y = 0; y < Settings.rowsCount; y++) {
                Location location = island.getLocation(x, y);
                processLifeCycle(location);
            }
        }
    }

    private void processLifeCycle(Location location) {
        List<Animal> animals = new CopyOnWriteArrayList<>(location.getAnimals());

        for (Animal animal : animals) {
            animal.decreaseSaturation(); // Уменьшаем сытость

            if (animal.getSaturation() <= 0) { // Удаляем, если голоден
                location.removeAnimal(animal);
//                System.out.println(animal.getClass().getSimpleName() + " умер от голода в клетке [" + location + "]");
            }
        }

        reproduceAnimals(location); // Вызываем размножение
    }

    private void reproduceAnimals(Location location) {
        List<Animal> animals = location.getAnimals();
        for (Animal animal : animals) {
            if (location.getAnimalCount(animal.getClass()) >= 2) { // ✅ Нужно минимум 2 особи одного вида
                Animal baby = animal.reproduce();
                if (baby != null) {
                    location.addAnimal(baby);
                    System.out.println(baby.getClass().getSimpleName() + " родился в клетке [" + location + "]");
                }
            }
        }
    }

    //  Получаем `maxNumber` для каждого животного из `Settings.java`
    private int getMaxNumberForAnimal(Animal animal) {
        if (animal instanceof Wolf) return Settings.wolfMaxNumber;
        if (animal instanceof Rabbit) return Settings.rabbitMaxNumber;
        if (animal instanceof Fox) return Settings.foxMaxNumber;
        if (animal instanceof Bear) return Settings.bearMaxNumber;
        if (animal instanceof Mouse) return Settings.mouseMaxNumber;
        if (animal instanceof Deer) return Settings.deerMaxNumber;
        if (animal instanceof Goat) return Settings.goatMaxNumber;
        if (animal instanceof Sheep) return Settings.sheepMaxNumber;
        if (animal instanceof Boar) return Settings.boarMaxNumber;
        if (animal instanceof Buffalo) return Settings.buffaloMaxNumber;
        if (animal instanceof Duck) return Settings.duckMaxNumber;
        if (animal instanceof Caterpillar) return Settings.caterpillarMaxNumber;
        return Integer.MAX_VALUE; // На случай, если животного нет в списке
    }
}
