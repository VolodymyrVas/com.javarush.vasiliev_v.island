package entity.creature.animal.herbivore;

import settings.Settings;

public class Horse extends Herbivore{
    public Horse() {
        super(Settings.horseWeight, Settings.horseSpeed, Settings.horseSaturation);
    }

    @Override
    public Horse reproduce() {
        return new Horse();
    }
}
