package Models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class Store {

    //region ATTRIBUTES
    private String name;
    private int maxProductsStock;
    private BigDecimal cashBalance;
    private List<Product> productsList;
    //endregion

    //region CONSTRUCTORS
    public Store() {
    }

    public Store(String name, int maxProductsStock, BigDecimal cashBalance) {
        this.name = name;
        this.maxProductsStock = maxProductsStock;
        this.cashBalance = cashBalance;
        this.productsList = new ArrayList<>();
    }

    public Store(String name, int maxProductsStock, BigDecimal cashBalance, List<Product> productsList) {
        this.name = name;
        this.maxProductsStock = maxProductsStock;
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

    public int getMaxProductsStock() {
        return maxProductsStock;
    }

    public void setMaxProductsStock(int maxProductsStock) {
        this.maxProductsStock = maxProductsStock;
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
                "\n MAX. PROD. STOCK...: " + this.maxProductsStock +
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
            counter += product.availableStock;
        }

        return counter;
    }

    //METODO PARA COMPRAR PRODUCTOS
    public void buyProduct(Product product) {

        //AGREGAR PROD A LA LISTA DE LA TIENDA
        //TODO: AGREGAR ATRIBUTO "COST" AL PRODUCT
        ////TODO: asignar el valor del salePrice del producto pasado por parametro al atributo "cost"
        //preguntar al usuario que ganancia quiere agregarle al producto
        //pedir que confirme o salir de la compra
        //
    }
}
