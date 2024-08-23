package Tools;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public final class Tools {
    public static String generateNextId(String lastId) {

        String prefix = lastId.substring(0, 2);
        String numberPart = lastId.substring(2);

        int numericId = Integer.parseInt(numberPart);
        numericId++;

        String newNumberPart = String.format("%03d", numericId);

        return prefix + newNumberPart;
    }

    public static void autoIncrementId(StringBuilder lastId, StringBuilder newId) {
        // Genera el nuevo ID
        String nextId = Tools.generateNextId(lastId.toString());

        // Asigna el nuevo ID a `newId` y actualiza `lastId`
        newId.setLength(0);
        newId.append(nextId);

        lastId.setLength(0);
        lastId.append(nextId);
    }

    public static float calculatePercentage(float totalValue, float percentage) {
        return (percentage * totalValue) / 100;
    }

    public static float percentageOfPartialValue(float totalValue, float partialValue) {
        return (partialValue * 100) / totalValue;
    }

    public static LocalDate generateRandomFutureDate() {
        // Obtener la fecha actual
        LocalDate today = LocalDate.now();

        // Generar un número aleatorio de días entre 31 y 365+30 (un año hacia adelante)
        long randomDays = ThreadLocalRandom.current().nextLong(31, 396);

        // Retornar la fecha actual más los días aleatorios generados
        return today.plusDays(randomDays);
    }

    //TODO: Luego hacer un estudio del minimo y maximo segun el tipo de alimento y refactorizar la firma del metodo
    //public static int generateRandomCalories(int minCalories, int maxCalories) {
    public static int generateRandomCalories() {

        int minCalories = 50;
        int maxCalories = 500;

        // Generar un número aleatorio de calorías dentro del rango especificado
        return ThreadLocalRandom.current().nextInt(minCalories, maxCalories + 1);
    }
}
