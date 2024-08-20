package Models.Submodels;

import Enums.Packaging;
import Models.Edible;

import java.time.LocalDate;

public final class Packaged extends Edible {

    //region ATTRIBUTES
    Packaging containerType;
    boolean isImported;
    //endregion

    //region CONSTRUCTORS
    public Packaged() {
    }

    public Packaged(Packaging containerType, boolean isImported) {
        this.containerType = containerType;
        this.isImported = isImported;
    }

    public Packaged(LocalDate expirationDate, float calories, Packaging containerType, boolean isImported) {

        super(expirationDate, calories);
        this.containerType = containerType;
        this.isImported = isImported;
    }

    public Packaged(String id, String description, int availableStock, float salePrice, float cost,
                    boolean availableForSale, LocalDate expirationDate, float calories, Packaging containerType,
                    boolean isImported) {

        super(id, description, availableStock, salePrice, cost, availableForSale, expirationDate, calories);
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
