package entity.creature.animal.predator;

import entity.creature.animal.Animal;
import settings.Settings;

public class Predator extends Animal {
    public Predator(int weight, int speed, int saturation) {
        this.weight = weight;
        this.speed = speed;
        this.saturation = saturation;
    }
}
