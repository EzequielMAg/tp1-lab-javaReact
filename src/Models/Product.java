package Models;

public abstract class Product {

    //region ATTRIBUTES
    protected String id;
    protected String description;
    protected int availableStock;
    protected float salePrice;
    //protected float profitPercentage;
    protected float cost; // Con este atributo y el "salePrice" puedo calcular la ganancia y luego el % ganancia
    protected boolean availableForSale;

    //endregion

    //region CONSTRUCTORS
    public Product() {
    }

    public Product(String id, String description, int availableStock, float salePrice, float cost,
                   boolean availableForSale) {
        this.id = id;
        this.description = description;
        this.availableStock = availableStock;
        this.salePrice = salePrice;
        this.cost = cost;
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

}
