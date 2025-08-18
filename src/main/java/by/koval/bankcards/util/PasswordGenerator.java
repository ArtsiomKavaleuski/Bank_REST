package by.koval.bankcards.util;

public class PasswordGenerator {
    public static String generatePassword(long passwordLength) {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < passwordLength; i++) {
            password.append((char) ((int) (Math.random() * 26) + 65));
        }
        return password.toString();
    }
}
