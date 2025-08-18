package by.koval.bankcards.util;

public class CardUtil {
    public static String maskCardNumber(String cardNumber) {
        return cardNumber.replaceAll("[^0-9]", "");
    }

    public static String generateCardNumber() {
        StringBuilder cardNumber = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            cardNumber.append(Math.random() * 10);
        }
        return cardNumber.toString();
    }
}
