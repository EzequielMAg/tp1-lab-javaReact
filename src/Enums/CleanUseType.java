package Enums;

public enum CleanUseType {
    UNASSIGNED("SIN ASIGNAR"),
    KITCHEN("COCINA"),
    BATHROOM("BAÑO"),
    CLOTHES("ROPA"),
    MULTIPURPOSE("MULTIPROPÓSITO"),
    PERSONAL_CARE("CUIDADO PERSONAL");

    public final String name;

    CleanUseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
