package entity.creature.animal.herbivore;


import settings.Settings;

public class Sheep extends Herbivore{
    public Sheep() {
        super(Settings.sheepWeight, Settings.sheepSpeed, Settings.sheepSaturation);
    }

    @Override
    public Sheep reproduce() {
        return new Sheep();
    }
}
