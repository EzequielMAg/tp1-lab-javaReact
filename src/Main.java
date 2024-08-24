import Enums.CleanUseType;
import Enums.DiscountType;
import Enums.Packaging;
import Models.Product;
import Models.Store;
import Models.Submodels.Cleaning;
import Models.Submodels.Discount;
import Models.Submodels.Drink;
import Models.Submodels.Packaged;
import Tools.Tools;
import Tools.Console;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //region Cargo una lista con los productos de un proveedor y los muestro
        List<Product> diarcoSupplier = loadStockSupplier();
        Console.showProductsInReducedFormat(diarcoSupplier);
        //endregion

        //region Instancio la clase Store, cargo sus datos y muestro la información junto con el stock de productos
        Store store = new Store("EGA", 1_000, BigDecimal.valueOf(1_000_000));
        store.setProductsList(loadStockStore());

        System.out.println(store);
        Console.showProducts(store.getProductsList());
        //endregion

        // COMPRANDO UN PRODUCTO
        store.buyProduct(diarcoSupplier.get(3), 7);

        // Muestro como quedo la tienda luego de hacer la compra de un producto
        System.out.println(store);

        // Creo una referencia local para acceder mas rapidamente a la lista de productos de la tienda
        List<Product> storeProductsList = store.getProductsList();

        // Muestro solo el producto agregado
        storeProductsList.get(storeProductsList.size() - 1).showProduct();

        // Muestro uno de mis productos en stock, que tiene un descuento aplicado y sin el atributo "cost" asignado
        // para calcular la ganancia real..
        storeProductsList.get(1).showProduct();
    }
    private static void pruebaProductosVacios() {
        Cleaning prodLimpieza = new Cleaning();
        System.out.println(prodLimpieza);

        Drink prodBebida  = new Drink();
        System.out.println(prodBebida);

        Packaged prodEnvasado = new Packaged();
        System.out.println(prodEnvasado);
    }

    private static List<Product> loadStockSupplier() {
        List<Product> diarcoSupplier = new ArrayList<>();

        //region PACKAGED PRODUCTS
        diarcoSupplier.add(new Packaged("Arroz Luchetti", 1500F, Tools.generateRandomFutureDate(),
                Tools.generateRandomCalories(), true, Packaging.PLASTIC_BAG));

        diarcoSupplier.add(new Packaged("Tallarin Matarazzo", 2000F,  new Discount(15F),
                LocalDate.parse("2025-03-15"), 210F, false, Packaging.PLASTIC_BAG));

        diarcoSupplier.add(new Packaged("Galletitas Oreo 300g", 2900F, LocalDate.parse("2024-11-10"),
                400F, false, Packaging.PLASTIC_BAG));
        //endregion

        //region DRINK PRODUCTS
        diarcoSupplier.add(new Drink("Fernet Branca 750cc", 12500F, new Discount(10F),
                LocalDate.parse("2030-10-20"),150F, false, 40F));

        diarcoSupplier.add(new Drink("Vino Trapiche Malbec", 6800F, Tools.generateRandomFutureDate(),
                600F, false, 14F));

        diarcoSupplier.add(new Drink("Gin Gordon's", 9500F,
                LocalDate.parse("2024-09-15"),180, true, 37.5F));
        //endregion

        //region CLEANING PRODUCTS
        diarcoSupplier.add(new Cleaning("Jabon SKIP liquido 500ml", 8650F, CleanUseType. CLOTHES));
        diarcoSupplier.add(new Cleaning("Detergente Magistral 700ml", 4200F, CleanUseType.MULTIPURPOSE));
        diarcoSupplier.add(new Cleaning("Cif 900ml", 4570F, CleanUseType.BATHROOM));
        diarcoSupplier.add(new Cleaning("Lavandina Ayudin 1L", 3500F, new Discount(7F), CleanUseType.MULTIPURPOSE));
        //endregion

        return diarcoSupplier;
       }

    private static List<Product> loadStockStore() {
        List<Product> storeStock = new ArrayList<>();

        //region PACKAGED PRODUCTS
        storeStock.add(new Packaged("Harina 0000 Marolio", 20, 1800F, 40F,
                LocalDate.parse("2025-01-10"), Tools.generateRandomCalories(), false, Packaging.PAPER_BAG));

        storeStock.add(new Packaged("Azúcar Ledesma 1kg", 15, 1900F, 25F,
                new Discount(5F), LocalDate.parse("2025-12-15"), 400F, true, Packaging.PLASTIC_BAG));

        storeStock.add(new Packaged("Leche SanCor 1L", 17, 2400F, 35F,
                LocalDate.parse("2024-10-20"), 150F, false, Packaging.TETRA_PACK));
        //endregion

        //region DRINK PRODUCTS
        storeStock.add(new Drink("Cerveza Quilmes 1L", 24, 2500F, 30F,
                LocalDate.parse("2024-09-30"),200F, false, 4.5F));

        storeStock.add(new Drink("Whisky Johnnie Walker Red Label", 3,29000F, 30F,
                new Discount(10F), LocalDate.parse("2030-05-25"), 800F, true, 40F));

        storeStock.add(new Drink("Gaseosa Coca-Cola 2.25L", 30, 3100F, 30F,
                LocalDate.parse("2024-02-10"), 300F, false, 0F));

        storeStock.add(new Drink("Tónica Schweppes 2.25L", 8, 2900F, 30F,
                LocalDate.parse("2024-12-01"), 150F, false, 0.0F));
        //endregion

        //region CLEANING PRODUCTS
        storeStock.add(new Cleaning("Desinfectante Mr. Músculo 1L", 6, 2980F, 35F,
                CleanUseType.MULTIPURPOSE));

        storeStock.add(new Cleaning("Limpiador Cif 750ml", 10, 2720F, 25F,
                new Discount(15F), CleanUseType.BATHROOM));

        storeStock.add(new Cleaning("Jabón en Barra Dove 100g", 15, 1550F, 20F,
                CleanUseType.PERSONAL_CARE));

        //endregion

        return storeStock;
    }

}

//region ATTRIBUTES
//endregion

//region CONSTRUCTORS
//endregion

//region GETTERS AND SETTERS
//endregion
