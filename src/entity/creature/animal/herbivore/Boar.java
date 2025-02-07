package entity.creature.animal.herbivore;

import settings.Settings;

public class Boar extends Herbivore{
    public Boar() {
        super(Settings.buffaloWeight, Settings.boarSpeed, Settings.boarSaturation);
    }

    @Override
    public Boar reproduce() {
        return new Boar();
    }
}

