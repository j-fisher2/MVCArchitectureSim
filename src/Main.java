import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        ProductDatabase database = new ProductDatabase();
        try {
            database.loadProducts("../products.csv"); // Load product data from a CSV file
        } catch (IOException e) {
            System.err.println("Error loading product data.");
            return;
        }

        Keyboard keyboard = new Keyboard();
        Display display = new Display();
        CashRegister cashRegister = new CashRegister(database);

        
        String keyboardInput = "12345";	//simulate keyboard input
        keyboard.setInput(keyboardInput);
        cashRegister.processScan(keyboard.getInput(), display);
    }
}
