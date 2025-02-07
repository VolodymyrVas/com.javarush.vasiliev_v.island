package entity.creature.animal.herbivore;

import settings.Settings;

public class Mouse extends Herbivore{
    public Mouse() {
        super(Settings.mouseWeight, Settings.mouseSpeed, Settings.mouseSaturation);
    }

    @Override
    public Mouse reproduce() {
        return new Mouse();
    }
}
