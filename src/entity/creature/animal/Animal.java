package entity.creature.animal;

public abstract class Animal {
    protected double weight;
    protected int speed;
    protected double saturation;
    protected double maxSaturation;

    public Animal(double weight, int speed, double saturation) {
        this.weight = weight;
        this.speed = speed;
        this.saturation = saturation;
        this.maxSaturation = saturation; // Максимальная сытость = начальная
    }
    public double getWeight() {
        return weight;
    }

    public void decreaseSaturation() {
        this.saturation -= 1; // Животное постепенно теряет сытость
    }

    public boolean isHungry() {
        return saturation < maxSaturation;
    }

    public void increaseSaturation(double amount) {
        this.saturation = Math.min(this.saturation + amount, maxSaturation);
    }

    public int getSpeed() {
        return speed;
    }

    public double getSaturation() {
        return saturation;
    }

    public abstract Animal reproduce();
}
