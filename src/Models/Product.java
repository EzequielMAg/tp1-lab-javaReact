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

    public Product(String description, float salePrice) {
        this.description = description;
        this.salePrice = salePrice;

        availableForSale = true;
        this.discount = new Discount();
    }

    public Product(String description, float salePrice, Discount discount) {
        this.description = description;
        this.salePrice = salePrice;
        this.discount = discount;

        availableForSale = true;
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
                "\n STOCK..............: " + this.availableStock + (this.availableStock > 1 ? " unidad" : " unidades") +
                "\n PRECIO.............: " + this.showSalePrice() +
                //"\n COSTO..............: " + this.cost + //lo habia planteado antes y lo elimine
                "\n GANANCIA...........: " + this.showProfit() +
                "\n DISPONIBLE P/ VTA..: " + (this.availableForSale ? "SI" : "NO") +

                (this.discount.getDiscountType() == DiscountType.NO_DISCOUNT ?
                    "" :
                    "\n DESCUENTO..........: " + this.showDiscount());
    }

    public void showProduct() {
        Console.cleanConsole();

        System.out.println("\033[33m-------------------------------------------------------------------------");
        System.out.println("                               PRODUCTO");
        System.out.println("-------------------------------------------------------------------------\u001B[0m");

        System.out.println(this);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
    }

    public void showProductFromSupplier() {
        // Hago este metodo porque el proveedor no va a querer mostrar todos los datos, algunos son privados.

        System.out.println(
                "\n ID DEL PRODUCTO....: " + this.id +
                "\n DESCRIPCIÓN........: " + (this.description == null ? "SIN DESCRIPCIÓN" : this.description) +
                // STOCK: planteé un stock ILIMITADO, por eso ni lo muestro
                //TODO: despues quiero plantear un stock LIMITADO, y que sea controlado cuando compro productos al proveedor.

                // GANANCIA: este atributo me parece privado, osea que no hace falta que lo sepa la tienda

                "\n PRECIO.............: " + this.showSalePrice() +

                // DISPONIBLE P/ VTA.: tampoco lo muestro porque yo planteo que todos los productos que tiene el prov.
                // estan disponibles
                        (this.discount.getDiscountType() == DiscountType.NO_DISCOUNT ?
                                "" :
                                "\n DESCUENTO..........: " + this.showDiscount()));
    }

    public String showSalePrice() {
        //Si NO TIENE DESCUENTO muestro el precio directamente
        if(this.discount.getDiscountType() == DiscountType.NO_DISCOUNT) {
            return "$" + this.salePrice;
        }

        //Si llego aca, es porque TIENE UN DESCUENTO -> tengo que hacer el calculo del precio final
        return "$" + this.finalPriceWithDiscount() + " (con descuento).    $" + this.salePrice + " (anterior)";
    }

    public String showDiscount() {
        DiscountType discountType = this.discount.getDiscountType();

        if(discountType == DiscountType.NO_DISCOUNT) {
            return discountType.getName();
        }

        if (discountType == DiscountType.PERCENTAGE) {
            return this.discount.getValue() + "%";
        }

        return this.calculateDiscountPercentage(this.salePrice, this.discount.getValue()) + "%";
    }

    public String showProfit() {

        // Si el producto NO TIENE DESCUENTO la ganancia no se modifica, sigue siendo la misma
        if(this.discount.getDiscountType() == DiscountType.NO_DISCOUNT) {
            return this.profitPercentage + "%";
        }

        //TODO:
        // En este punto, el producto TIENE UN DESCUENTO -> debo calcular la GANANCIA REAL
        // Tengo que plantear un atributo COST, aunque puedo calcularlo sin el costo... DEBO TENER CARGADA LA GANANCIA
        // Y si no la tengo cargada aun?
        // 1° SE DEBE RESOLVER LA COMPRA..... Tiene que estar el atributo COST, y apenas se compra un producto para la
        // tienda se debe asignar "salePrice" al "cost". Luego si E dcto llamar al metodo "finalProfitAfterDiscount()"
        //float newProfit =

        return "";
    }

    public float calculateDiscountPercentage(float originalValue, float targetValue) {
        float difference = originalValue - targetValue;
        return Tools.percentageOfPartialValue(originalValue, difference);
    }

    public float finalPriceWithDiscount() {
        float remainingPercentage = 100 - this.discount.getValue();
        return (remainingPercentage * this.salePrice) / 100;
    }

    public float finalProfitAfterDiscount() {



        return 0.0f;
    }
}