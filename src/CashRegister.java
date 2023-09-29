

public class CashRegister {
    private ProductDatabase database;

    public CashRegister(ProductDatabase database) {
        this.database = database;
    }

    public void processScan(String productId, Display display) {
        Product product = database.lookupProduct(productId);
        if (product != null) {
            String result = "Product Name: " + product.getName() + ", Price: $" + product.getPrice();
            display.displayMessage(result);
        } else {
            display.displayMessage("Product not found");
        }
    }
}