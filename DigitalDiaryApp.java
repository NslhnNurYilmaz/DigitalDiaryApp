import java.util.Scanner;

public class DigitalDiaryApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static Encryption encryption;
    private static FolderManager folderManager;
    private static NoteManager noteManager;

    public static void main(String[] args) {
        System.out.println("Welcome to Digital Diary!");
        setupPassword();
        String folderName = folderManager.createFolder();
        diaryMenu(folderName);
    }

    private static void setupPassword() {
        System.out.println("Set up your diary password:");
        String password = scanner.nextLine();
        encryption = new Encryption(password); 
        folderManager = new FolderManager();
        noteManager = new NoteManager(encryption);
        System.out.println("Password set successfully!");
    }

    private static void diaryMenu(String folderName) {
        while (true) {
            System.out.println("\nDiary Menu:");
            System.out.println("1. Create a new note");
            System.out.println("2. Read a note");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> noteManager.createNote(folderName);
                case 2 -> {
                    if (encryption.verifyPassword()) {
                        noteManager.readNote(folderName);
                    } else {
                        System.out.println("Incorrect password. Access denied!");
                    }
                }
                case 3 -> {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}