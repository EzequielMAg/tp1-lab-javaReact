package Models.Submodels;

import Enums.Packaging;
import Models.Edible;

import java.time.LocalDate;

public class Packaged extends Edible {

    //region ATTRIBUTES
    Packaging containerType;
    boolean isImported;
    //region

    //region CONSTRUCTORS
    public Packaged() {
    }

    public Packaged(String id, String description, int quantity, double amount, float profitPercentage, boolean availableForSale, LocalDate expirationDate, float calories, Packaging containerType, boolean isImported) {
        super(id, description, quantity, amount, profitPercentage, availableForSale, expirationDate, calories);
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
