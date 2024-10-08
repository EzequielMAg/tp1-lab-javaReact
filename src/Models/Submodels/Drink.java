package Models.Submodels;

import Models.Edible;
import Tools.Tools;

import java.time.LocalDate;

public final class Drink extends Edible {

    //region ATTRIBUTES
    public static StringBuilder lastId = new StringBuilder("AC000");
    private float alcoholContent;
    //endregion

    //region CONSTRUCTORS
    public Drink() {
        Tools.autoIncrementId(lastId, super.id);
    }

    public Drink(String description, float salePrice, LocalDate expirationDate, float calories,
                 boolean isImported, float alcoholContent) {

        super(description, salePrice, expirationDate, calories, isImported);
        this.alcoholContent = alcoholContent;
        Tools.autoIncrementId(lastId, super.id);
    }

    public Drink(String description, float salePrice, Discount discount, LocalDate expirationDate, float calories,
                 boolean isImported, float alcoholContent) {

        super(description, salePrice, discount, expirationDate, calories, isImported);
        this.alcoholContent = alcoholContent;
        Tools.autoIncrementId(lastId, super.id);
    }

    public Drink(String description, int availableStock, float salePrice, float profitPercentage,
                 LocalDate expirationDate, float calories, boolean isImported,
                 float alcoholContent) {

        super(description, availableStock, salePrice, profitPercentage, expirationDate, calories, isImported);
        this.alcoholContent = alcoholContent;
        Tools.autoIncrementId(lastId, super.id);
    }

    public Drink(String description, int availableStock, float salePrice, float profitPercentage, Discount discount,
                 LocalDate expirationDate, float calories, boolean isImported,
                 float alcoholContent) {

        super(description, availableStock, salePrice, profitPercentage, discount, expirationDate, calories, isImported);
        this.alcoholContent = alcoholContent;
        Tools.autoIncrementId(lastId, super.id);
    }

    public Drink(StringBuilder id, String description, int availableStock, float salePrice, float profitPercentage,
                 float cost, boolean availableForSale, Discount discount, LocalDate expirationDate, float calories,
                 boolean isImported, float alcoholContent) {

        super(id, description, availableStock, salePrice, profitPercentage, cost, availableForSale, discount,
                expirationDate, calories, isImported);
        this.alcoholContent = alcoholContent;
    }
    //endregion

    //region GETTERS AND SETTERS
    public float getAlcoholContent() {
        return this.alcoholContent;
    }

    public void setAlcoholContent(float alcoholContent) {
        this.alcoholContent = alcoholContent;
    }
    //endregion

    @Override
    public String toString() {
        return super.toString() +
                "\n ALCOHOL............: " + this.alcoholContent + "%";
    }
}
