import java.util.Scanner;
public class Encryption {
    private final String encryptedPassword;

    public Encryption(String password) {
        this.encryptedPassword = encryptPassword(password);
    }

    private String encryptPassword(String password) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : password.toCharArray()) {
            encrypted.append((char) (c + 3)); 
        }
        return encrypted.toString();
    }

    public boolean verifyPassword() {
        System.out.println("Enter your password:");
        Scanner scanner = new Scanner(System.in);
        String inputPassword = scanner.nextLine();
        return encryptedPassword.equals(encryptPassword(inputPassword));
    }
}