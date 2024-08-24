package Tools;

import Models.Product;

import java.util.List;

public final class Console {

    public static void cleanConsole() {
        for(int i=0; i<10; i++) {
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
    //TODO: crear metodo que imprima lineas "-------" asi como 20 "-", o q sea un metodo q repita N veces una impresion

    //TODO: crear otro metodo que segun la longitud del string que se le pase, haga el calculo para imprimirlo centrado
    //      a la caja de lineas


}
