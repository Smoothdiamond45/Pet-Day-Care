package models;


public class Cat extends Mammal {

    private String favouriteToy;
    private boolean indoorCat;

    public Cat(String name, int id, Owner owner, int age, char sex, boolean neutered, double weight, boolean vaccinated, String favouriteToy, boolean indoorCat) {
        super(name, id, owner, age, sex, neutered, weight, vaccinated);
        this.favouriteToy = favouriteToy;
        this.indoorCat = indoorCat;
    }

    public void setIndoorCat(boolean indoorCat) {
        this.indoorCat = indoorCat;
    }

    public String getFavouriteToy() {
        return favouriteToy;
    }

    @Override
    public double calculateWeeklyFee() {
        double dailyRate = indoorCat ? 25.0 : 20.0;
        return dailyRate * numOfDaysAttending();
    }

    @Override
    public String toString() {
        return "Cat{name='" + getName() + "', favouriteToy='" + favouriteToy + "', indoorCat=" + indoorCat
                + ", sex=" + getSex() + ", neutered=" + isNeutered()
                + ", weight=" + getWeight() + ", vaccinated=" + isVaccinated() + "}";
    }

    public void setFavouriteToy(String favouriteToy) {
        this.favouriteToy = favouriteToy;
    }

    public boolean isIndoorCat() {
        return indoorCat;
    }
}
