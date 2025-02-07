package entity.creature.animal.herbivore;

import settings.Settings;

public class Buffalo extends Herbivore{
    public Buffalo() {
        super(Settings.buffaloWeight, Settings.buffaloSpeed, Settings.buffaloSaturation);
    }

    @Override
    public Buffalo reproduce() {
        return new Buffalo();
    }
}
