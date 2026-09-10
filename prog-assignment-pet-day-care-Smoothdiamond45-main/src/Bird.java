package models;

public abstract class Bird extends Pet {

    private double wingSpan;
    private boolean canFly;

    public Bird(String name, int id, Owner owner, int age, double wingSpan, boolean canFly) {
        super(name, id, owner, age);
        this.wingSpan = wingSpan;
        this.canFly = canFly;
    }

    public double getWingSpan() {
        return wingSpan;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Bird bird = (Bird) obj;
        return Double.compare(bird.wingSpan, wingSpan) == 0
                && canFly == bird.canFly
                && getName().equals(bird.getName());
    }

    public void setWingSpan(double wingSpan) {
        this.wingSpan = wingSpan;
    }

    @Override
    public abstract String toString();

    @Override
    public int hashCode() {
        int result = Double.hashCode(wingSpan);
        result = 31 * result + Boolean.hashCode(canFly);
        return result;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }
}