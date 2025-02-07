package entity.creature.animal.herbivore;

import settings.Settings;

public class Deer extends Herbivore{
    public Deer() {
        super(Settings.deerWeight, Settings.deerSpeed, Settings.deerSaturation);
    }

    @Override
    public Deer reproduce() {
        return new Deer();
    }
}
