package Models.Submodels;

import Models.Edible;

import java.time.LocalDate;

public final class Drink extends Edible {

    //region ATTRIBUTES
    private float alcoholContent;
    private boolean IsImported;
    //endregion

    //region CONSTRUCTORS

    public Drink() {
    }

    public Drink(float alcoholContent, boolean isImported) {
        this.alcoholContent = alcoholContent;
        IsImported = isImported;
    }

    public Drink(LocalDate expirationDate, float calories, float alcoholContent, boolean isImported) {
        super(expirationDate, calories);
        this.alcoholContent = alcoholContent;
        IsImported = isImported;
    }

    public Drink(String id, String description, int availableStock, float salePrice, float cost,
                 boolean availableForSale, LocalDate expirationDate, float calories, float alcoholContent,
                 boolean isImported) {

        super(id, description, availableStock, salePrice, cost, availableForSale, expirationDate, calories);
        this.alcoholContent = alcoholContent;
        IsImported = isImported;
    }

    //endregion

    //region GETTERS AND SETTERS
    public float getAlcoholContent() {
        return alcoholContent;
    }

    public void setAlcoholContent(float alcoholContent) {
        this.alcoholContent = alcoholContent;
    }

    public boolean isImported() {
        return IsImported;
    }

    public void setImported(boolean imported) {
        IsImported = imported;
    }
    //endregion
}
