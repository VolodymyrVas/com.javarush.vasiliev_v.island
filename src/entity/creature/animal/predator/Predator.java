package entity.creature.animal.predator;

import entity.creature.animal.Animal;

public abstract class Predator extends Animal {
    public Predator(double weight, int speed, double saturation) {
        super(weight, speed, saturation);
    }

    @Override
    public abstract Predator reproduce(); //
}
