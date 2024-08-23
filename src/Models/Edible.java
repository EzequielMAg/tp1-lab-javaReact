package Models;

import Models.Submodels.Discount;
import Tools.Tools;

import java.time.LocalDate;

public abstract class Edible extends Product {

    //region ATTRIBUTES
    private LocalDate expirationDate;
    private float calories;
    private boolean isImported;

    //endregion

    //region CONSTRUCTORS
    public Edible() {
    }

    public Edible(LocalDate expirationDate, float calories, boolean isImported) {
        this.expirationDate = expirationDate;
        this.calories = calories;
        this.isImported = isImported;
    }

    public Edible(String description, float salePrice, LocalDate expirationDate, float calories,
                  boolean isImported) {

        super(description, salePrice);
        this.expirationDate = expirationDate;
        this.calories = calories;
        this.isImported = isImported;
    }

    public Edible(String description, float salePrice, Discount discount, LocalDate expirationDate, float calories,
                  boolean isImported) {

        super(description, salePrice, discount);
        this.expirationDate = expirationDate;
        this.calories = calories;
        this.isImported = isImported;
    }

    public Edible(String description, int availableStock, float salePrice, float profitPercentage, LocalDate expirationDate,
                  float calories) {

        super(description, availableStock, salePrice, profitPercentage);
        this.expirationDate = expirationDate;
        this.calories = calories;
    }
    //endregion

    //region GETTERS AND SETTERS
    public LocalDate getExpirationDate() {
        return this.expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public float getCalories() {
        return this.calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public boolean isImported() {
        return isImported;
    }

    public void setImported(boolean imported) {
        this.isImported = imported;
    }

    //endregion


    @Override
    public String toString() {
        return super.toString() +
                "\n FECHA DE VTO.......: " + this.expirationDate +
                "\n CALORÍAS...........: " + this.calories +
                "\n PROD. IMPORTADO....: " + (this.isImported ? "SI": "NO");
    }
}
