package Models;

import java.math.BigDecimal;
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


}
