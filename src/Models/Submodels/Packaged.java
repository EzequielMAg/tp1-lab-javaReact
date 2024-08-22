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
    private boolean isImported;
    //endregion

    //region CONSTRUCTORS
    public Packaged() {
        Tools.autoIncrementId(lastId, super.id);
        this.containerType = Packaging.UNASSIGNED; // Asigno uno por default para que no apunte a null
    }

    public Packaged(Packaging containerType, boolean isImported) {
        Tools.autoIncrementId(lastId, super.id);
        this.containerType = containerType;
        this.isImported = isImported;
    }

    public Packaged(LocalDate expirationDate, float calories, Packaging containerType, boolean isImported) {
        super(expirationDate, calories);

        Tools.autoIncrementId(lastId, super.id);
        this.containerType = containerType;
        this.isImported = isImported;
    }

    public Packaged(String description, int availableStock, float salePrice, float cost, LocalDate expirationDate,
                    float calories, Packaging containerType, boolean isImported) {

        super(description, availableStock, salePrice, cost, expirationDate, calories);
        Tools.autoIncrementId(lastId, super.id);
        this.containerType = containerType;
        this.isImported = isImported;
    }

    //endregion

    //region GETTERS AND SETTERS
    public Packaging getContainerType() {
        return this.containerType;
    }

    public void setContainerType(Packaging containerType) {
        this.containerType = containerType;
    }

    public boolean getIsImported() {
        return this.isImported;
    }

    public void setIsImported(boolean isImported) {
        this.isImported = isImported;
    }
    //endregion

    @Override
    public String toString() {
        return super.toString() +
                "\n TIPO DE ENVASE.....: " + this.containerType.getName() +
                "\n PROD. IMPORTADO....: " + (this.isImported ? "SI": "NO");
    }
}
