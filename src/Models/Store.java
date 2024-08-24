package Models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import Enums.DiscountType;
import Models.Submodels.Discount;
import Tools.Tools;

public final class Store {

    //region ATTRIBUTES
    private String name;
    private int maxProductCapacity;
    private BigDecimal cashBalance;
    private List<Product> productsList;
    //endregion

    //region CONSTRUCTORS
    public Store() {
    }

    public Store(String name, int maxProductCapacity, BigDecimal cashBalance) {
        this.name = name;
        this.maxProductCapacity = maxProductCapacity;
        this.cashBalance = cashBalance;
        this.productsList = new ArrayList<>();
    }

    public Store(String name, int maxProductCapacity, BigDecimal cashBalance, List<Product> productsList) {
        this.name = name;
        this.maxProductCapacity = maxProductCapacity;
        this.cashBalance = cashBalance;
        this.productsList = productsList;
    }
    //endregion

    //region GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxProductCapacity() {
        return maxProductCapacity;
    }

    public void setMaxProductCapacity(int maxProductCapacity) {
        this.maxProductCapacity = maxProductCapacity;
    }

    public BigDecimal getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(BigDecimal cashBalance) {
        this.cashBalance = cashBalance;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }
    //endregion

    @Override
    public String toString() {
        return "\n NOMBRE DE LA TIENDA: " + this.name +
                "\n MAX. PROD. STOCK...: " + this.maxProductCapacity +
                "\n DINERO EN CAJA.....: $" + this.cashBalance +
                "\n\n PRODUCTOS DISTINTOS: " + this.quantityDifferentProducts() +
                "\n TOTAL PROD. STOCK..: " + this.totalQuantityProductsStock();
    }

    //METODO QUE RETORNE LA CANTIDAD DE PRODUCTOS DISTINTOS QUE TIENE LA TIENDA
    public int quantityDifferentProducts() {
        if(this.productsList == null)
            return 0;

        return this.productsList.size();
    }

    //METODO QUE RETORNE LA CANTIDAD TOTAL DE UNIDADES DE PRODUCTOS QUE TIENE LA TIENDA
    public int totalQuantityProductsStock() {
        if(this.productsList == null) return 0;

        int counter = 0;

        for(Product product : this.productsList) {
            counter += product.getAvailableStock();
        }

        return counter;
    }

    //METODO PARA COMPRAR PRODUCTOS
    public void buyProduct(Product productToBuy, int quantityToBuy) {

        // Si product tiene un descuento, el atributo "salePrice" no es el precio final con dcto -> DEBO CALCULARLO
        float finalPrice = Product.finalPriceWithDiscount( productToBuy.getSalePrice(), productToBuy.getDiscount() );
        float totalToPay = quantityToBuy * finalPrice;

        if(!hasSufficientBalance(totalToPay)) {
            System.out.println("El producto no podrá ser agregado a la tienda por saldo insuficiente en la caja.");

        } else if(!hasSufficientStorage(quantityToBuy)) {
            System.out.println("No se pueden agregar nuevos productos a la tienda ya que se alcanzó el máximo de stock.");

        } else {
            /* Por el momento no tengo productos repetidos, pero luego al comprar alguno seguro que si,
            y tendria que hacer una validacion para que no se cree otro sino, que se busque si existe uno igual,
            y simplemente si pasa todas las validaciones anteriores, aumentar la cantidad en stock de unidades.
            Aunque esto esta nal porque seguro que voy a tener fechas de vencimientos distintas, entonces
            deberia refactorizar y tener un arreglo de arreglos de productos */

            Product productToAdd = Tools.clonProduct(productToBuy);

            /* Como planteé que el proveed. tiene stock ilimitado, va a tener todx lo que le quiera comprar (su
               atributo "availableStock" no lo inicialice nunca)*/
            /*TODO: preguntar al usuario que ganancia quiere agregarle al producto
                pedir que confirme o salir de la compra*/
            productToAdd.setAvailableStock(quantityToBuy);
            productToAdd.setCost(finalPrice);

            // Agrego un 30% de ganancia al producto por default
            productToAdd.setProfitPercentage(30F);

            // Calculo y seteo el nuevo precio de venta segun la ganancia que se aplico
            productToAdd.setSalePrice( Product.finalPriceWithProfit(productToAdd.getCost(),
                                            productToAdd.getProfitPercentage()) );

            //Por defecto todos los productos agregados estarán disponibles para la venta.
            productToAdd.setAvailableForSale(true);

            //Si el producto que estoy comprando TIENE DESCUENTO, lo saco, y luego vere si le asigno alguno.
            if(Product.hasDiscount( productToAdd.getDiscount() )) {
                productToAdd.setDiscount(new Discount());
            }

            //AGREGAR PROD A LA LISTA DE LA TIENDA ------------------------------
            this.productsList.add(productToAdd);

            // DESCONTAR DINERO DE LA CAJA
            this.setCashBalance( this.getCashBalance().subtract(BigDecimal.valueOf(totalToPay)) );
        }
    }

    private boolean hasSufficientBalance(float amount) {
        return this.cashBalance.floatValue() >= amount;
    }

    public boolean hasSufficientStorage(int additionalProducts) {
        return this.totalQuantityProductsStock() + additionalProducts <= this.maxProductCapacity;
    }

}
