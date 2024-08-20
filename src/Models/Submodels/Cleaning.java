package Models.Submodels;

import Enums.CleanUseType;
import Models.Product;

public class Cleaning extends Product {

    private CleanUseType cleaningSurface;

    //region CONSTRUCTORS
    public Cleaning() {
    }

    public Cleaning(String id, String description, int quantity, double amount, float profitPercentage, boolean availableForSale, CleanUseType cleaningSirface) {
        super(id, description, quantity, amount, profitPercentage, availableForSale);
        this.cleaningSurface = cleaningSirface;
    }
    //endregion
}
