package entity.creature.animal.predator;

import settings.Settings;

public class Snake extends Predator{
    public Snake() {
        super(Settings.snakeWeight, Settings.snakeSpeed, Settings.snakeSaturation);
    }

    @Override
    public Snake reproduce() {
        return new Snake();
    }
}
