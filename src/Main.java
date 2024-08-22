import Enums.CleanUseType;
import Enums.Packaging;
import Models.Product;
import Models.Submodels.Cleaning;
import Models.Submodels.Drink;
import Models.Submodels.Packaged;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        //listProductsHarcodeada();
        pruebaProductosVacios();


    }

    public static void listProductsHarcodeada() {
        Product[] products = new Product[10];

        products[0] = new Packaged("Rice", 50, 1500F, 600F,
                LocalDate.parse("2024-12-31"),130, Packaging.BAG, true);
        products[1] = new Packaged("Pasta", 30, 2000F, 1290F,
                LocalDate.parse("2025-03-15"),210, Packaging.BAG, false);
        products[2] = new Packaged("Cookies", 20, 1900F, 850F,
                LocalDate.parse("2024-11-10"),400, Packaging.BAG, true);

        products[3] = new Drink("Soda", 40, 1200F, 700F,
                LocalDate.parse("2024-10-20"),150, 0.0F, false);
        products[4] = new Drink("Wine", 25, 3900F, 2300F,
                LocalDate.parse("2025-02-28"),600, 7.5F, false  );
        products[5] = new Drink("Juice", 35, 3800F, 2700F,
                LocalDate.parse("2024-09-15"),180, 14.2F, false);

        products[6] = new Cleaning("Dish Soap", 60, 2650, 1500, CleanUseType.KITCHEN);
        products[7] = new Cleaning("Laundry Detergent", 40, 4200F, 2900F, CleanUseType.KITCHEN);
        products[8] = new Cleaning("Bathroom Cleaner", 50, 4570F, 3200F, CleanUseType.BATHROOM);
        products[9] = new Cleaning("Multipurpose Cleaner", 70, 7500F, 4800F, CleanUseType.MULTIPURPOSE);

        for (Product product : products) {
            System.out.println(product);
        }
    }

    public static void pruebaProductosVacios() {
        Cleaning prodLimpieza = new Cleaning();
        System.out.println(prodLimpieza);

        Drink prodBebida  = new Drink();
        System.out.println(prodBebida);

        Packaged prodEnvasado = new Packaged();
        System.out.println(prodEnvasado);
    }

}

//region ATTRIBUTES
//endregion

//region CONSTRUCTORS
//endregion

//region GETTERS AND SETTERS
//endregion
