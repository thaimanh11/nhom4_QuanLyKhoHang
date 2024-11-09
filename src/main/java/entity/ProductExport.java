
package entity;


public class ProductExport {
    private int id;
    private int productId;
    private int amount;
    private int inStockLeft;

    public ProductExport(int id, int productId, int amount, int inStockLeft) {
        this.id = id;
        this.productId = productId;
        this.amount = amount;
        this.inStockLeft = inStockLeft;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getInStockLeft() {
        return inStockLeft;
    }

    public void setInStockLeft(int inStockLeft) {
        this.inStockLeft = inStockLeft;
    }
    
    
}
