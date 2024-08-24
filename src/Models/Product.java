package Models;

import Enums.DiscountType;
import Models.Submodels.Discount;
import Tools.Console;
import Tools.Tools;

public abstract class Product {

    //region ATTRIBUTES
    //Es autoincremental. Lo implemente en los submodels, ya q c/ clase tiene un ID de letras !=
    protected StringBuilder id = new StringBuilder(); //Queria modularizar y tuve que volver el String en StringBuilder.
    private String description;
    private int availableStock;
    private float salePrice;
    private float profitPercentage;

    // Siento necesario agregar este atributo "COST" para que al momento de comprar un producto,
    // sea salePriceSupplier != salePriceStore
    private float cost;

    private boolean availableForSale;
    private Discount discount;
    //endregion

    //region CONSTRUCTORS
    public Product() {
        availableForSale = true;
        discount = new Discount(); // Instancio un obj Discount por default para que no apunte a null y genere problemas
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

    public Product(StringBuilder id, String description, int availableStock, float salePrice, float profitPercentage, float cost, boolean availableForSale, Discount discount) {
        this.id = id;
        this.description = description;
        this.availableStock = availableStock;
        this.salePrice = salePrice;
        this.profitPercentage = profitPercentage;
        this.cost = cost;
        this.availableForSale = availableForSale;
        this.discount = discount;
    }
    //endregion

    //region GETTERS AND SETTERS
    public StringBuilder getId() {
        return id;
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

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
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
                "\n STOCK..............: " + this.availableStock + (this.availableStock == 1 ? " unidad" : " unidades") +
                "\n PRECIO.............: " + this.showSalePrice() +
                "\n GANANCIA...........: " + this.showProfit() +
                "\n COSTO..............: " + this.cost +
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
        System.out.println("\n\n\n\n\n\n\n\n\n");
    }

    public void showProductInReducedFormat()  {
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

    //TODO: refactor name because it does not show the sale price
    public String showSalePrice() {

        float finalSalePrice = Product.finalPriceWithDiscount(this.salePrice, this.discount);

        // NO TIENE DESCUENTO
        if(this.salePrice == finalSalePrice) return "$" + this.salePrice;

        // TIENE DESCUENTO
        return "$" + finalSalePrice + " (con descuento).  $" + this.salePrice + " (anterior)";
    }

    //TODO: refactor name because it does not show the discount
    private String showDiscount() {

        if(!hasDiscount(this.discount)) return DiscountType.NO_DISCOUNT.getName();

        if (this.discount.getDiscountType() == DiscountType.PERCENTAGE) {
            return this.discount.getValue() + "%";
        }

        return this.calculateDiscountPercentage(this.salePrice, this.discount.getValue()) + "%";
    }

    //TODO: refactor name because it does not show the profit
    private String showProfit() {

        //1° EVALUO SI ESTA CARGADO EL ATRIBUTO O SI ES VALIDO (positiva > 0) o retorna un msj de error //TODO: EXCEPCIONS
        if(this.profitPercentage == 0F) return "NO SE HA ESTABLECIDO UNA GANANCIA PARA ESTE PRODUCTO AUN!";
        if(this.profitPercentage < 0) return "LA GANANCIA CARGADA NO ES VALIDA!";

        float finalProfit = finalProfitAfterDiscount();

        // Si el producto NO TIENE DESCUENTO la ganancia no se modifica, sigue siendo la misma
        if(finalProfit == this.profitPercentage) return finalProfit + "%";

        // TIENE DESCUENTO -> muestro la ganancia actual y la anterior
        return finalProfit + "% (real).  " + this.profitPercentage + "% (anterior)";
    }

    private float calculateDiscountPercentage(float originalValue, float targetValue) {
        float difference = originalValue - targetValue;
        return Tools.percentageOfPartialValue(originalValue, difference);
    }

    public static float finalPriceWithDiscount(float salePrice, Discount discount) {
        //Si NO TIENE DESCUENTO retorno directamente el precio de venta asignado
        if(!hasDiscount(discount)) {
            return salePrice;
        }

        // TIENE UN DESCUENTO -> tengo que ver el tipo de dcto y hacer el calculo correspondiente del precio final
        if(discount.getDiscountType() == DiscountType.TARGET_PRICE) {
            // En este caso no hay que hacer ningun calculo, ya que con TARGET_PRICE ya tengo el value final
            return discount.getValue();
        }

        // discount.getDiscountType() == DiscountType.PERCENTAGE; -> Aca si hay que hacer un calculo, o unos..
        float remainingPercentage = 100 - discount.getValue();
        return Tools.calculatePercentage(salePrice, remainingPercentage);
        //return (remainingPercentage * salePrice) / 100;
    }

    private float finalProfitAfterDiscount() {
        // Si el producto NO TIENE DESCUENTO la ganancia no se modifica, sigue siendo la misma
        if(!hasDiscount(this.discount)) return this.profitPercentage;

        // En este punto, el producto TIENE UN DESCUENTO y la ganancia es > 0 -> debo calcular la GANANCIA REAL
        float finalPrice = finalPriceWithDiscount(this.salePrice, this.discount);

        // Puedo calcularla sin la necesidad de que el atributo "cost" este cargado...
        if(this.cost <= 0F) {
            float calculatedCost = Tools.percentageOfPartialValue(100+this.profitPercentage, this.salePrice);

            // Ganancia REAL calculada luego del dcto:
            return (Tools.percentageOfPartialValue(calculatedCost, finalPrice) - 100F);
        }

        // En este punto, el atributo "cost" tiene un valor
        return (Tools.percentageOfPartialValue(this.cost, finalPrice) - 100F);
    }

    public static float finalPriceWithProfit(float cost, float profitPercentage) {
        //TODO: futura refactorizacion agregando logica de validaciones
        float totalPercentage = 100 + profitPercentage;
        return Tools.calculatePercentage(cost, totalPercentage);
        //return (totalPercentage * cost) / 100;
    }

    public static boolean hasDiscount(Discount discount) {
        //return !(discount == null || discount.getDiscountType() == DiscountType.NO_DISCOUNT);
        return discount != null && discount.getDiscountType() != DiscountType.NO_DISCOUNT;
    }
}