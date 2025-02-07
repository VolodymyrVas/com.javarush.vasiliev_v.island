package entity.creature.animal.predator;

import settings.Settings;

public class Wolf extends Predator{
    public Wolf() {
        super(Settings.wolfWeight, Settings.wolfSpeed, Settings.wolfSaturation);
    }

    @Override
    public Wolf reproduce() {
        return new Wolf();
    }
}
