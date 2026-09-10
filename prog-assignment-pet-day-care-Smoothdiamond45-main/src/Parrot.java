package models;

public class Parrot extends Bird {

    private int vocabularySize;

    public Parrot(String name, int id, Owner owner, int age, double wingSpan, boolean canFly, int vocabularySize) {
        super(name, id, owner, age, wingSpan, canFly);
        this.vocabularySize = vocabularySize;
    }

    public void setVocabularySize(int vocabularySize) {
        this.vocabularySize = vocabularySize;
    }

    @Override
    public String toString() {
        return "Parrot name='" + getName() + "', vocabularySize=" + vocabularySize
                + ", wingSpan=" + getWingSpan() + ", canFly=" + isCanFly() + "}";
    }

    public String getVocabularySize() {
        return String.valueOf(vocabularySize);
    }

    @Override
    public double calculateWeeklyFee() {
        double dailyRate = 10.0 + (vocabularySize * 0.5);
        return dailyRate * numOfDaysAttending();
    }
}
