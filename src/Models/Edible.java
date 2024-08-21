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

    public Edible(LocalDate expirationDate, float calories) {
        this.expirationDate = expirationDate;
        this.calories = calories;
    }

    public Edible(String description, int availableStock, float salePrice, float cost, LocalDate expirationDate,
                  float calories) {

        super(description, availableStock, salePrice, cost);
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
