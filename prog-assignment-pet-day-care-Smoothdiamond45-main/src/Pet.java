package models;

public abstract class Pet {

    private int age;
    private int id;
    private String name;
    private boolean[] daysAttending;
    private Owner owner;

    public Pet(String name, int id, Owner owner, int age) {
        this.name = name;
        this.id = id;
        this.owner = owner;
        this.age = age;
        this.daysAttending = new boolean[7];
    }

    public void checkOut(int day) {
        if (day >= 0 && day < daysAttending.length) {
            daysAttending[day] = false;
        }
    }

    public String getName() {
        return name;
    }

    public Owner getOwner() {
        return owner;
    }

    public boolean[] getDaysAttending() {
        return daysAttending;
    }

    public int getAge() {
        return age;
    }

    public void initName(String name) {
        this.name = name;
    }

    public void initAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDaysAttending(boolean[] daysAttending) {
        this.daysAttending = daysAttending;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void checkIn(int day) {
        if (day >= 0 && day < daysAttending.length) {
            daysAttending[day] = true;
        }
    }

    public int numOfDaysAttending() {
        int count = 0;
        for (boolean day : daysAttending) {
            if (day) count++;
        }
        return count;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract double calculateWeeklyFee();

    @Override
    public abstract String toString();
}