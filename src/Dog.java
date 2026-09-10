package models;

public class Dog extends Mammal {

    public static final float NONDANGEROUS_DAILY_RATE = 30.0f;
    public static final float DANGEROUS_DAILY_RATE = 40.0f;

    private boolean dangerousBreed;
    private String breed;

    public Dog(String name, int id, Owner owner, int age, char sex, boolean neutered, double weight, boolean vaccinated, boolean dangerousBreed, String breed) {
        super(name, id, owner, age, sex, neutered, weight, vaccinated);
        this.dangerousBreed = dangerousBreed;
        this.breed = breed;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Dog dog = (Dog) obj;
        return getId() == dog.getId() && getName().equals(dog.getName());
    }

    public void setDangerousBreed(boolean dangerousBreed) {
        this.dangerousBreed = dangerousBreed;
    }

    public boolean isDangerousBreed() {
        return dangerousBreed;
    }

    @Override
    public double calculateWeeklyFee() {
        float dailyRate = dangerousBreed ? DANGEROUS_DAILY_RATE : NONDANGEROUS_DAILY_RATE;
        return dailyRate * numOfDaysAttending();
    }

    @Override
    public String toString() {
        return "Dog{name='" + getName() + "', breed='" + breed + "', dangerous=" + dangerousBreed
                + ", sex=" + getSex() + ", neutered=" + isNeutered()
                + ", weight=" + getWeight() + ", vaccinated=" + isVaccinated() + "}";
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }
}