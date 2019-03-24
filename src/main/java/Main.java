import product.ProductDatabase;

public class Main {
    public static void main(String[] args) {
        ProductDatabase.getINSTANCE().initializeDatabase();
        Menu.start();
    }
}
