package Models.Submodels;

import Enums.CleanUseType;
import Models.Product;

public final class Cleaning extends Product {

    private CleanUseType cleaningSurface;

    //region CONSTRUCTORS
    public Cleaning() {
    }

    public Cleaning(CleanUseType cleaningSurface) {
        this.cleaningSurface = cleaningSurface;
    }

    public Cleaning(String id, String description, int availableStock, float salePrice, float cost,
                    boolean availableForSale, CleanUseType cleaningSurface) {

        super(id, description, availableStock, salePrice, cost, availableForSale);
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
