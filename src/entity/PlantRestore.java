package entity;

import generating.Generating;

public class PlantRestore implements Runnable {
    private final Island island;

    public PlantRestore(Island island) {
        this.island = island;
    }

    @Override
    public void run() {
        Generating generating = new Generating(island);
        generating.generatePlants();
    }
}
