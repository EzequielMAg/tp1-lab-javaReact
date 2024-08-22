package Models.Submodels;

import Enums.CleanUseType;
import Models.Product;
import Tools.Tools;

public final class Cleaning extends Product {

    public static StringBuilder lastId = new StringBuilder("AZ000");
    private CleanUseType cleaningSurface;

    //region CONSTRUCTORS
    public Cleaning() {
        Tools.autoIncrementId(lastId, super.id);
        this.cleaningSurface = CleanUseType.UNASSIGNED; // Asigno uno por default para que no apunte a null
    }

    public Cleaning(CleanUseType cleaningSurface) {
        Tools.autoIncrementId(lastId, super.id);

        this.cleaningSurface = cleaningSurface;
    }

    public Cleaning(String description, int availableStock, float salePrice, float profitPercentage, CleanUseType cleaningSurface) {
        super(description, availableStock, salePrice, profitPercentage);
        Tools.autoIncrementId(lastId, super.id);
        this.cleaningSurface = cleaningSurface;
    }
    //endregion

    //region GETTERS AND SETTERS
    public CleanUseType getCleaningSurface() {
        return cleaningSurface;
    }

    public void setCleaningSurface(CleanUseType cleaningSurface) {
        this.cleaningSurface = cleaningSurface;
    }
    //endregion

    @Override
    public String toString() {
        return super.toString() +
                "\n PROD. PARA.........: " + this.cleaningSurface.getName();
    }


}
