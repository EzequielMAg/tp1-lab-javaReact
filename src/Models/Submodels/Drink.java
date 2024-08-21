package Models.Submodels;

import Models.Edible;
import Tools.Tools;

import java.time.LocalDate;

public final class Drink extends Edible {

    //region ATTRIBUTES
    public static String lastId = "AC000";
    private float alcoholContent;
    private boolean IsImported;
    //endregion

    //region CONSTRUCTORS

    public Drink() {
        super.id = Tools.generateNextId(lastId);
        lastId = id;
    }

    public Drink(float alcoholContent, boolean isImported) {
        this.alcoholContent = alcoholContent;

        super.id = Tools.generateNextId(lastId);
        lastId = id;

        IsImported = isImported;
    }

    public Drink(LocalDate expirationDate, float calories, float alcoholContent, boolean isImported) {

        super(expirationDate, calories);
        super.id = Tools.generateNextId(lastId);
        lastId = id;

        this.alcoholContent = alcoholContent;
        IsImported = isImported;
    }

    public Drink(String description, int availableStock, float salePrice, float cost, LocalDate expirationDate,
                 float calories, float alcoholContent, boolean isImported) {

        super(description, availableStock, salePrice, cost, expirationDate, calories);
        super.id = Tools.generateNextId(lastId);
        lastId = id;

        this.alcoholContent = alcoholContent;
        IsImported = isImported;
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
        return this.IsImported;
    }

    public void setImported(boolean imported) {
        IsImported = imported;
    }
    //endregion

    @Override
    public String toString() {
        return super.toString() +
                "\n ALCOHOL............: " + this.alcoholContent +
                "\n PROD. IMPORTADO....: " + this.IsImported;
    }
}
