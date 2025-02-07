package entity.creature.animal.herbivore;

import settings.Settings;

public class Caterpillar extends Herbivore{
    public Caterpillar() {
        super(Settings.caterpillarWeight, Settings.caterpillarSpeed, Settings.caterpillarSaturation);
    }

    @Override
    public Caterpillar reproduce() {
        return new Caterpillar();
    }
}
