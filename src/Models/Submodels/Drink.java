package Models.Submodels;

import Models.Edible;
import Tools.Tools;

import java.time.LocalDate;

public final class Drink extends Edible {

    //region ATTRIBUTES
    public static StringBuilder lastId = new StringBuilder("AC000");
    private float alcoholContent;
    private boolean isImported;
    //endregion

    //region CONSTRUCTORS

    public Drink() {
        Tools.autoIncrementId(lastId, super.id);
    }

    public Drink(float alcoholContent, boolean isImported) {
        Tools.autoIncrementId(lastId, super.id);
        this.alcoholContent = alcoholContent;
        this.isImported = isImported;
    }

    public Drink(LocalDate expirationDate, float calories, float alcoholContent, boolean isImported) {
        super(expirationDate, calories);

        Tools.autoIncrementId(lastId, super.id);
        this.alcoholContent = alcoholContent;
        this.isImported = isImported;
    }

    public Drink(String description, int availableStock, float salePrice, float profitPercentage, LocalDate expirationDate,
                 float calories, float alcoholContent, boolean isImported) {

        super(description, availableStock, salePrice, profitPercentage, expirationDate, calories);
        Tools.autoIncrementId(lastId, super.id);
        this.alcoholContent = alcoholContent;
        this.isImported = isImported;
    }
    //endregion

    //region GETTERS AND SETTERS
    public float getAlcoholContent() {
        return this.alcoholContent;
    }

    public void setAlcoholContent(float alcoholContent) {
        this.alcoholContent = alcoholContent;
    }

    public boolean isImported() {
        return this.isImported;
    }

    public void setImported(boolean imported) {
        isImported = imported;
    }
    //endregion

    @Override
    public String toString() {
        return super.toString() +
                "\n ALCOHOL............: " + this.alcoholContent + "%" +
                "\n PROD. IMPORTADO....: " + (this.isImported ? "SI" : "NO");
    }
}
