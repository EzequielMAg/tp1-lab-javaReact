package Models;

import Enums.DiscountType;
import Models.Submodels.Discount;
import Tools.Console;

public abstract class Product {

    //region ATTRIBUTES
    protected String id;
    protected String description;
    protected int availableStock;
    protected float salePrice;
    //protected float profitPercentage;
    protected float cost; // Con este atributo y el "salePrice" puedo calcular la ganancia y luego el % ganancia
    protected boolean availableForSale;
    protected Discount discount;
    //endregion

    //region CONSTRUCTORS
    public Product() {
        availableForSale = true;
        discount = new Discount(DiscountType.NO_DISCOUNT);
    }

    public Product(String description, int availableStock, float salePrice, float cost) {
        //this.id; VOLVERLO AUTOINCREMENTAL

        this.description = description;
        this.availableStock = availableStock;
        this.salePrice = salePrice;
        this.cost = cost;

        this.availableForSale = true;
        discount = new Discount(DiscountType.NO_DISCOUNT);
    }
    //endregion

    //region GETTERS AND SETTERS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(int availableStock) {
        this.availableStock = availableStock;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public boolean isAvailableForSale() {
        return availableForSale;
    }

    public void setAvailableForSale(boolean availableForSale) {
        this.availableForSale = availableForSale;
    }
    //endregion

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || this.getClass() != obj.getClass()) return false;

        Product product = (Product) obj;
        return this.id.equals(product.id);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\n ID DEL PRODUCTO....: " + this.id +
                "\n DESCRIPCIÓN........: " + this.description +
                "\n STOCK..............: " + this.availableStock + " unidades" +
                "\n PRECIO.............: " + this.salePrice +
                "\n COSTO..............: " + this.cost +
                "\n DISPONIBLE P/ VTA..: " + this.availableForSale +
                "\n DESCUENTO..........: " + ((this.discount.getDiscountType()==DiscountType.NO_DISCOUNT) ?
                                                    this.discount.getDiscountType().getName():
                                                    "calcular dcto en %"); //TODO: falta crear metodo para tal fin
    }

    public void viewProduct() {
        Console.cleanConsole();

        System.out.println("\033[33m-------------------------------------------------------------------------");
        System.out.println("                               PRODUCTO");
        System.out.println("-------------------------------------------------------------------------\u001B[0m");

        System.out.println(this);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
    }


}