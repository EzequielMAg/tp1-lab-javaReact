package Models.Submodels;

import Enums.CleanUseType;
import Enums.Packaging;
import Models.Edible;
import Tools.Tools;

import java.time.LocalDate;

public final class Packaged extends Edible {

    //region ATTRIBUTES
    public static StringBuilder lastId = new StringBuilder("AB000");
    private Packaging containerType;
    //endregion

    //region CONSTRUCTORS
    public Packaged() {
        Tools.autoIncrementId(lastId, super.id);
        this.containerType = Packaging.UNASSIGNED; // Asigno uno por default para que no apunte a null
    }

    public Packaged(Packaging containerType) {
        this.containerType = containerType;
        Tools.autoIncrementId(lastId, super.id);
    }

    public Packaged(String description, float salePrice, LocalDate expirationDate, float calories,
                    boolean isImported, Packaging containerType) {

        super(description, salePrice, expirationDate, calories, isImported);
        this.containerType = containerType;
        Tools.autoIncrementId(lastId, super.id);
    }

    public Packaged(String description, float salePrice, Discount discount, LocalDate expirationDate, float calories,
                    boolean isImported, Packaging containerType) {

        super(description, salePrice, discount, expirationDate, calories, isImported);
        this.containerType = containerType;
        Tools.autoIncrementId(lastId, super.id);
    }

    public Packaged(LocalDate expirationDate, float calories, boolean isImported, Packaging containerType) {

        super(expirationDate, calories, isImported);
        this.containerType = containerType;
        Tools.autoIncrementId(lastId, super.id);
    }

    public Packaged(String description, int availableStock, float salePrice, float profitPercentage,
                    LocalDate expirationDate, float calories, boolean isImported,
                    Packaging containerType) {

        super(description, availableStock, salePrice, profitPercentage, expirationDate, calories, isImported);
        this.containerType = containerType;
        Tools.autoIncrementId(lastId, super.id);
    }

    public Packaged(String description, int availableStock, float salePrice, float profitPercentage, Discount discount,
                    LocalDate expirationDate, float calories, boolean isImported,
                    Packaging containerType) {

        super(description, availableStock, salePrice, profitPercentage, discount, expirationDate, calories, isImported);
        this.containerType = containerType;
        Tools.autoIncrementId(lastId, super.id);
    }

    //endregion

    //region GETTERS AND SETTERS
    public Packaging getContainerType() {
        return this.containerType;
    }

    public void setContainerType(Packaging containerType) {
        this.containerType = containerType;
    }

    //endregion

    @Override
    public String toString() {
        return super.toString() +
                "\n TIPO DE ENVASE.....: " + this.containerType.getName();
    }
}
