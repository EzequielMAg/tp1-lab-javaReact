package Enums;

public enum DiscountType {
    NO_DISCOUNT("SIN DESCUENTO"),
    TARGET_PRICE("PRECIO OBJETIVO"),
    PERCENTAGE("PORCENTAJE");

    public final String name;

    DiscountType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
