package pl.kurs.model;

public class LSD implements PriceCalculator {
    private int amountOfIngredients;
    private int timeOfHigh;

    public LSD(int amountOfIngredients, int timeOfHigh) {
        this.amountOfIngredients = amountOfIngredients;
        this.timeOfHigh = timeOfHigh;
    }

    @Override
    public double getPrice() {
        return amountOfIngredients * 10 + timeOfHigh * 5;
    }
}
