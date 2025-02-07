package entity.creature.animal.herbivore;

import entity.creature.animal.Animal;

public abstract class Herbivore extends Animal {
    public Herbivore(double weight, int speed, double saturation) {
        super(weight, speed, saturation);
    }

    @Override
    public abstract Herbivore reproduce();
}
