package entity.creature.animal.herbivore;

import settings.Settings;

public class Duck extends Herbivore{
    public Duck() {
        super(Settings.duckWeight, Settings.duckSpeed, Settings.duckSaturation);
    }

    @Override
    public Duck reproduce() {
        return new Duck();
    }
}
