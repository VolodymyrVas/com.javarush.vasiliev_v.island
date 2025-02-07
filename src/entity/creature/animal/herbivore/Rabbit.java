package entity.creature.animal.herbivore;

import settings.Settings;

public class Rabbit extends Herbivore{
    public Rabbit() {
        super(Settings.rabbitWeight, Settings.rabbitSpeed, Settings.rabbitSaturation);
    }

    @Override
    public Rabbit reproduce() {
        return new Rabbit();
    }
}
