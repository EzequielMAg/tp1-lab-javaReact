package Models.Submodels;

import Enums.Packaging;
import Models.Edible;
import Tools.Tools;

import java.time.LocalDate;

public final class Packaged extends Edible {

    //region ATTRIBUTES
    //public static StringBuilder lastId = new StringBuilder("AB000");
    public static String lastId = "AB000";
    Packaging containerType;
    boolean isImported;
    //endregion

    //region CONSTRUCTORS
    public Packaged() {
        super.id = Tools.generateNextId(lastId);
        lastId = id;
    }

    public Packaged(Packaging containerType, boolean isImported) {

        super.id = Tools.generateNextId(lastId);
        lastId = id;

        this.containerType = containerType;
        this.isImported = isImported;
    }

    public Packaged(LocalDate expirationDate, float calories, Packaging containerType, boolean isImported) {

        super(expirationDate, calories);
        super.id = Tools.generateNextId(lastId);
        lastId = id;

        this.containerType = containerType;
        this.isImported = isImported;
    }

    public Packaged(String description, int availableStock, float salePrice, float cost, LocalDate expirationDate,
                    float calories, Packaging containerType, boolean isImported) {

        super(description, availableStock, salePrice, cost, expirationDate, calories);
        super.id = Tools.generateNextId(lastId);
        lastId = id;

        this.containerType = containerType;
        this.isImported = isImported;
    }

    //endregion

    //region GETTERS AND SETTERS
    public Packaging getContainerType() {
        return containerType;
    }

    public void setContainerType(Packaging containerType) {
        this.containerType = containerType;
    }

    public boolean isImported() {
        return isImported;
    }

    public void setImported(boolean imported) {
        isImported = imported;
    }
    //endregion
}
