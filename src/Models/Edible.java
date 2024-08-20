package Models;

import java.time.LocalDate;

public abstract class Edible extends Product {

    //region ATTRIBUTES
    private LocalDate expirationDate;
    private float calories;
    //endregion

    //region CONSTRUCTORS
    public Edible() {
    }

    public Edible(String id, String description, int quantity, double amount, float profitPercentage, boolean availableForSale, LocalDate expirationDate, float calories) {
        super(id, description, quantity, amount, profitPercentage, availableForSale);
        this.expirationDate = expirationDate;
        this.calories = calories;
    }
    //endregion

    //region GETTERS AND SETTERS
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }
    //endregion


}
