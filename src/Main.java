import Enums.CleanUseType;
import Enums.DiscountType;
import Enums.Packaging;
import Models.Product;
import Models.Submodels.Cleaning;
import Models.Submodels.Discount;
import Models.Submodels.Drink;
import Models.Submodels.Packaged;
import Tools.Tools;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        //listProductsHarcodeada();
        //pruebaProductosVacios();

        supplierProducts();
    }

/*    public static void listProductsHarcodeada() {
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
    }*/

    public static void pruebaProductosVacios() {
        Cleaning prodLimpieza = new Cleaning();
        System.out.println(prodLimpieza);

        Drink prodBebida  = new Drink();
        System.out.println(prodBebida);

        Packaged prodEnvasado = new Packaged();
        System.out.println(prodEnvasado);
    }

    public static void supplierProducts() {
        Product[] diarcoSupplier = new Product[10];

        //region PACKAGED PRODUCTS
        diarcoSupplier[0] = new Packaged("Arroz Luchetti", 1500F, Tools.generateRandomFutureDate(),
                Tools.generateRandomCalories(), true, Packaging.BAG);

        diarcoSupplier[1] = new Packaged("Tallarin Matarazzo", 2000F,  new Discount(15F),
                LocalDate.parse("2025-03-15"), 210F, false, Packaging.BAG);

        diarcoSupplier[2] = new Packaged("Galletitas Oreo 300g", 2900F, LocalDate.parse("2024-11-10"),
                400F, false, Packaging.BAG);
        //endregion

        //region DRINK PRODUCTS
        diarcoSupplier[3] = new Drink("Fernet Branca 750cc", 12500F, new Discount(10F),
                LocalDate.parse("2030-10-20"),150F, false, 40F);

        diarcoSupplier[4] = new Drink("Vino Trapiche Malbec", 6800F, Tools.generateRandomFutureDate(),
                600F, false, 14F);

        diarcoSupplier[5] = new Drink("Gin Gordon's", 9500F,
                LocalDate.parse("2024-09-15"),180, true, 37.5F);
        //endregion

        //region CLEANING PRODUCTS
        diarcoSupplier[6] = new Cleaning("Jabon SKIP liquido 500ml", 8650F, CleanUseType. CLOTHES);
        diarcoSupplier[7] = new Cleaning("Detergente Magistral 700ml", 4200F, CleanUseType.MULTIPURPOSE);
        diarcoSupplier[8] = new Cleaning("Cif 900ml", 4570F, CleanUseType.BATHROOM);
        diarcoSupplier[9] = new Cleaning("Lavandina Ayudin 1L", 3500F, new Discount(7F),
                CleanUseType.MULTIPURPOSE);
        //endregion

        for (Product product : diarcoSupplier) {
            product.showProductFromSupplier();
        }

    }


}

//region ATTRIBUTES
//endregion

//region CONSTRUCTORS
//endregion

//region GETTERS AND SETTERS
//endregion
