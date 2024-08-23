package Models.Submodels;

import Enums.DiscountType;

public final class Discount {

    //region ATTRIBUTES
    private DiscountType discountType;
    private float value;
    //endregion

    //region CONSTRUCTORS
    public Discount() {
        discountType = DiscountType.NO_DISCOUNT;
    }

    // Con este constructor plantéo que si creo un objeto Discount pasandole un valor float por parametro,
    // tal valor representa el descuento a aplicar.
    public Discount(float value) {
        this.value = value;
        this.discountType = DiscountType.PERCENTAGE;
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

    @Override
    public String toString() {
        return "\n TIPO DE DESCUENTO....: " + this.discountType.getName() +
                "\n VALOR........: " + this.value;
    }
}
