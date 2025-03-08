import java.io.File;
import java.util.Scanner;
public class FolderManager {

    public String createFolder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name for your diary folder:");
        String folderName = scanner.nextLine();
        File folder = new File(folderName);

        if (!folder.exists()) {
            if (folder.mkdir()) {
                System.out.println("Folder '" + folderName + "' created successfully!");
            } else {
                System.out.println("Failed to create folder. Exiting...");
                System.exit(0);
            }
        } else {
            System.out.println("Folder already exists. Using existing folder.");
        }
        return folderName;
    }
}