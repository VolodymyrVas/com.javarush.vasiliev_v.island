package entity.creature.animal.herbivore;


import settings.Settings;

public class Goat extends Herbivore{
    public Goat() {
        super(Settings.goatWeight, Settings.goatSpeed, Settings.goatSaturation);
    }

    @Override
    public Goat reproduce() {
        return new Goat();
    }
}
