
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProductDatabase {
    private Map<String, Product> products = new HashMap<>();

    public void loadProducts(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                String productId = parts[0];
                String productName = parts[1];
                double productPrice = Double.parseDouble(parts[2]);
                products.put(productId, new Product(productName, productPrice));
            }
        }
        reader.close();
    }

    public Product lookupProduct(String productId) {
        return products.get(productId);
    }
}