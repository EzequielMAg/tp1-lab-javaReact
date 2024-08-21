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
}
