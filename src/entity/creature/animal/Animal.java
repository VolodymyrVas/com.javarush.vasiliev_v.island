package entity.creature.animal;

import entity.Location;
import entity.creature.Creature;

import static entity.Location.*;

public abstract class Animal extends Creature {


    // ОБЩИЕ ХАРАКТЕРИСТИКИ
    // СЫТОСТЬ satiety(сытость) = ? вес
    // ВЕС ЖИВОТНОГО
    protected int weight;
    // СКОРОСТЬ ПЕРЕМЕЩЕНИЯ
    protected int speed;
    protected int saturation;

    void eat(Creature c) {

        // ДЕФОЛТНАЯ РЕАЛИЗАЦИЯ
        // КТО ИМЕННО ЭТОТ Creature БУДЕТ ВЛИЯТЬ НА ФОРМАТ ПОЕДАНИЯ
        // КОГДА СТАНЕТ ПОНЯТНО КТО КОНКРЕТНО ЭТО Creature
        // МЫ МОЖЕМ ОПРЕДЕЛИТЬ ВЕРОЯТНОСТЬ ЕГО ПОЕДАНИЯ И РЕАЛИЗОВАТЬ ЭТУ ЛОГИКУ
    }

    void move() {
        // ДЕФОЛТНАЯ РЕАЛИЗАЦИЯ
    }

    Creature reproduce() {
        // ДЕФОЛТНАЯ РЕАЛИЗАЦИЯ
        return null;
    }

    // ✅ Удаление животного (например, если его съели)
    public boolean die(Animal animal) {
        return Location.getAnimalsOnCell().remove(animal);
    }

//    void decreaseWeight(){
//    }

}
