package Enums;

public enum CleanUseType {
    KITCHEN("COCINA"),
    BATHROOM("BAÑO"),
    CLOTHES("ROPA"),
    MULTIPURPOSE("MULTIPROPÓSITO");

    public final String name;

    CleanUseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
