package models;


public abstract class Mammal extends Pet {

    private char sex;
    private boolean neutered;
    private double weight;
    private boolean vaccinated;

    public Mammal(String name, int id, Owner owner, int age, char sex, boolean neutered, double weight, boolean vaccinated) {
        super(name, id, owner, age);
        this.sex = sex;
        this.neutered = neutered;
        this.weight = weight;
        this.vaccinated = vaccinated;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public double getWeight() {
        return weight;
    }

    public void setNeutered(boolean neutered) {
        this.neutered = neutered;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public boolean isNeutered() {
        return neutered;
    }

    public char getSex() {
        return sex;
    }

    @Override
    public abstract String toString();
}