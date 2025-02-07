package entity.creature.animal.predator;

import settings.Settings;

public class Fox extends Predator{
    public Fox() {
        super(Settings.foxWeight, Settings.foxSpeed, Settings.foxSaturation);
    }

    @Override
    public Fox reproduce() {
        return new Fox();
    }
}
