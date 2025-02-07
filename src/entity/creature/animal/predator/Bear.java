package entity.creature.animal.predator;

import settings.Settings;

public class Bear extends Predator{
    public Bear() {
        super(Settings.bearWeight, Settings.bearSpeed, Settings.bearSaturation);
    }

    @Override
    public Bear reproduce() {
        return new Bear();
    }
}
