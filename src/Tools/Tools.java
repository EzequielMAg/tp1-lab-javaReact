package Tools;

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
}
