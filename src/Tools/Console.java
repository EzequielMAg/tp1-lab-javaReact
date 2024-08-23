package Tools;

import Models.Product;

import java.util.List;

public final class Console {

    public static void cleanConsole() {
        for(int i=0; i<20; i++) {
            System.out.print("\n");
        }
    }

    public static void showProducts(List<Product> productsList) {
        for (Product product : productsList) {
            System.out.println(product);
        }
    }

    public static void showProductsInReducedFormat(List<Product> productsList) {
        for (Product product : productsList) {
            product.showProductInReducedFormat();
        }
    }
}
