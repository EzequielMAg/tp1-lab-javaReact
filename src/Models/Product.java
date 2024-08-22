package Models;

import Enums.DiscountType;
import Models.Submodels.Discount;
import Tools.Console;
import Tools.Tools;

public abstract class Product {

    //region ATTRIBUTES
    //Es autoincremental. Lo implemente en los submodels, ya q c/ clase tiene un ID de letras !=
    protected StringBuilder id = new StringBuilder();
    protected String description;
    protected int availableStock;
    protected float salePrice;
    protected float profitPercentage;
    //protected float cost;
    protected boolean availableForSale;
    protected Discount discount;
    //endregion

    //region CONSTRUCTORS
    public Product() {
        availableForSale = true;
        discount = new Discount(); //Instancio un objeto Discount por default para que no apunte a null
    }

    public Product(String description, int availableStock, float salePrice, float profitPercentage) {

        this.description = description;
        this.availableStock = availableStock;
        this.salePrice = salePrice;
        this.profitPercentage = profitPercentage;

        this.availableForSale = true;
        discount = new Discount();
    }

    public Product(String description, int availableStock, float salePrice, float profitPercentage, Discount discount) {
        this.description = description;
        this.availableStock = availableStock;
        this.salePrice = salePrice;
        this.profitPercentage = profitPercentage;
        this.discount = discount;

        this.availableForSale = true;
    }
    //endregion

    //region GETTERS AND SETTERS
    public StringBuilder getId() {
        return id;
    }

    public void setId(StringBuilder id) {
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

    public float getProfitPercentage() {
        return this.profitPercentage;
    }

    public void setProfitPercentage(float profitPercentage) {
        this.profitPercentage = profitPercentage;
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
        return this.id.toString().equals(product.id.toString());
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
                "\n DESCRIPCIÓN........: " + (this.description == null ? "SIN DESCRIPCIÓN" : this.description) +
                "\n STOCK..............: " + this.availableStock + " unidades" +
                "\n PRECIO.............: $" + this.salePrice +
                //"\n COSTO..............: " + this.cost +
                "\n GANANCIA...........: " + this.profitPercentage + "%" +
                "\n DISPONIBLE P/ VTA..: " + (this.availableForSale ? "SI" : "NO") +
                "\n DESCUENTO..........: " + ((this.discount.getDiscountType()==DiscountType.NO_DISCOUNT) ?
                                                this.discount.getDiscountType().getName() :

                                                    (this.discount.getDiscountType()==DiscountType.PERCENTAGE ?
                                                        this.discount.getValue() + "%":
                                                        this.calculateDiscountPercentage(this.salePrice, this.discount.getValue())));
    }

    public void viewProduct() {
        Console.cleanConsole();

        System.out.println("\033[33m-------------------------------------------------------------------------");
        System.out.println("                               PRODUCTO");
        System.out.println("-------------------------------------------------------------------------\u001B[0m");

        System.out.println(this);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
    }

    public float calculateDiscountPercentage(float originalValue, float targetValue) {
        float difference = originalValue - targetValue;
        return Tools.percentageOfPartialValue(originalValue, difference);
    }

}