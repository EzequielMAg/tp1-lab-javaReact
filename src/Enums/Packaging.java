package Enums;

public enum Packaging {
    CAN("LATA"),
    PLASTIC_BOTTLE("BOTELLA DE PLASTICO"),
    GLASS_BOTTLE("BOTELLA DE VIDRIO"),
    TETRA_PACK("TETRA PAK"),
    VACUUM_SEALED("ENVASADO AL VACIO"),
    JAR("FRASCO"),
    BAG("BOLSA"),
    BOX("CAJA");

    private final String name;

    Packaging(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
