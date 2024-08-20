package Models;

public abstract class Product {

    //region ATTRIBUTES
    protected String id;
    protected String description;
    protected int quantity;
    protected double amount;
    protected float profitPercentage;
    protected boolean availableForSale;
    //endregion

    //region CONSTRUCTORS
    public Product() {
    }

    public Product(String id, String description, int quantity, double amount, float profitPercentage, boolean availableForSale) {
        this.id = id;
        this.description = description;
        this.quantity = quantity;
        this.amount = amount;
        this.profitPercentage = profitPercentage;
        this.availableForSale = availableForSale;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public float getProfitPercentage() {
        return profitPercentage;
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

}
