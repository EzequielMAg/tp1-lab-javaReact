package Models.Submodels;

import Models.Edible;

import java.time.LocalDate;

public class Drink extends Edible {

    //region ATTRIBUTES
    private float alcogolContent;
    private boolean IsImported;
    //endregion

    //region CONSTRUCTORS

    public Drink() {
    }

    public Drink(float alcogolContent, boolean isImported) {
        this.alcogolContent = alcogolContent;
        IsImported = isImported;
    }

    public Drink(String id, String description, int quantity, double amount, float profitPercentage, boolean availableForSale, LocalDate expirationDate, float calories, float alcogolContent, boolean isImported) {
        super(id, description, quantity, amount, profitPercentage, availableForSale, expirationDate, calories);
        this.alcogolContent = alcogolContent;
        IsImported = isImported;
    }

    //endregion

    //region GETTERS AND SETTERS
    public float getAlcogolContent() {
        return alcogolContent;
    }

    public void setAlcogolContent(float alcogolContent) {
        this.alcogolContent = alcogolContent;
    }

    public boolean isImported() {
        return IsImported;
    }

    public void setImported(boolean imported) {
        IsImported = imported;
    }
    //endregion
}
