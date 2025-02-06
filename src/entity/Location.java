package entity;

import entity.creature.animal.Animal;
import entity.creature.plant.Plant;
import settings.Settings;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Location {
    private final int x;
    private final int y;

    private static final List<Animal> animalsOnCell = new CopyOnWriteArrayList<>();
    private static final List<Plant> plantsOnCell = new CopyOnWriteArrayList<>();

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public List<Animal> getAnimals() {
        return new ArrayList<>(animalsOnCell);
    }


    public List<Plant> getPlants() {
        return plantsOnCell;
    }

    // Метод для подсчёта животных определённого типа
    public long getAnimalCount(Class<? extends Animal> type) {
        return animalsOnCell.stream().filter(type::isInstance).count();
    }

    // Метод для добавления животных с лимитом
    public boolean addAnimal(Animal animal) {
        animalsOnCell.add(animal);
        return true;
    }

    public void removeAnimal(Animal animal) {
        Location.animalsOnCell.remove(animal);
    }

    // Метод для подсчёта растений
    public long getPlantCount(Plant plant) {
        return plantsOnCell.stream().count();
    }

    // Метод для добавления растений с лимитом
    public boolean addPlant(Plant plant) {
        plantsOnCell.add(plant);
        return true;
    }

    public void removePlant(Plant plant) {
        Location.plantsOnCell.remove(plant);
    }
}
