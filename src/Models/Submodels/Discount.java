package Models.Submodels;

import Enums.DiscountType;

public final class Discount {

    //region ATTRIBUTES
    private DiscountType discountType;
    private float value;
    //endregion

    //region CONSTRUCTORS
    public Discount() {
    }

    public Discount(DiscountType discountType, float value) {
        this.discountType = discountType;
        this.value = value;
    }
    //endregion

    //region GETTERS AND SETTERS
    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
    //endregion

}
