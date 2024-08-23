package Enums;

public enum Packaging {
    // Me parecio conveniente tener un ENUM con todos los posibles envoltorios/paquetes de los productos:
    // Y tambien que siempre haya un valor que reemplace al null, en este caso UNASSIGNED p/ asignarlo por default
    UNASSIGNED("SIN ASIGNAR"),
    CAN("LATA"),
    PLASTIC_BOTTLE("BOTELLA DE PLASTICO"),
    GLASS_BOTTLE("BOTELLA DE VIDRIO"),
    TETRA_PACK("TETRA PAK"),
    VACUUM_SEALED("ENVASADO AL VACIO"),
    JAR("FRASCO"),
    PLASTIC_BAG("BOLSA PLASTICA"),
    PAPER_BAG("BOLSA DE PAPEL"),

    BOX("CAJA");

    private final String name;

    Packaging(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
