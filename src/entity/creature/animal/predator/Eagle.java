package entity.creature.animal.predator;

import settings.Settings;

public class Eagle extends Predator{
    public Eagle() {
        super(Settings.eagleWeight, Settings.eagleSpeed, Settings.eagleSaturation);
    }

    @Override
    public Eagle reproduce() {
        return new Eagle();
    }
}
