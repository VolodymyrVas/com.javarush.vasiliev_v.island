package entity;

import entity.creature.animal.Animal;
import entity.creature.plant.Plant;
import settings.Settings;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Location {
    private static final List<Animal> animalsOnCell = new CopyOnWriteArrayList<>();
    private static final List<Plant> plantsOnCell = new CopyOnWriteArrayList<>();

    public static List<Animal> getAnimalsOnCell() {
        return animalsOnCell;
    }

    public static List<Plant> getPlantsOnCell() {
        return plantsOnCell;
    }

    // ✅ Метод для подсчёта животных определённого типа
    public long getAnimalCount(Class<? extends Animal> type) {
        return animalsOnCell.stream().filter(type::isInstance).count();
    }

    // ✅ Метод для добавления животных с лимитом
    public boolean addAnimal(Animal animal) {
        int maxLimit = Settings.wolfMaxNumber; // ❗ Пример, надо сделать универсально
        if (getAnimalCount(animal.getClass()) < maxLimit) {
            animalsOnCell.add(animal);
            return true;
        }
        return false; // Лимит достигнут
    }

    public void removeAnimal(Animal animal) {
        Location.animalsOnCell.remove(animal);
    }
}
