package Models.Submodels;

import Enums.CleanUseType;
import Models.Product;
import Tools.Tools;

public final class Cleaning extends Product {

    public static String lastId = "AZ000";
    private CleanUseType cleaningSurface;

    //region CONSTRUCTORS
    public Cleaning() {
        super.id = Tools.generateNextId(lastId); // Asigna el ID actual y luego incrementa el contador
        lastId = id;
    }

    public Cleaning(CleanUseType cleaningSurface) {
        super.id = Tools.generateNextId(lastId);
        lastId = id;

        this.cleaningSurface = cleaningSurface;
    }

    public Cleaning(String description, int availableStock, float salePrice, float cost, CleanUseType cleaningSurface) {

        super(description, availableStock, salePrice, cost);
        super.id = Tools.generateNextId(lastId);
        lastId = id;

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
}
