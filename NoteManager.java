import java.io.*;
import java.util.Scanner;

public class NoteManager {
    private final Encryption encryption;

    public NoteManager(Encryption encryption) {
        this.encryption = encryption;
    }

    public void createNote(String folderName) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of your note:");
        String noteName = scanner.nextLine();
        File noteFile = new File(folderName + "/" + noteName + ".txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(noteFile))) {
            System.out.println("Write your note (type 'END' on a new line to save):");
            String line;
            while (!(line = scanner.nextLine()).equals("END")) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Note saved successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the note: " + e.getMessage());
        }
    }

    public void readNote(String folderName) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the note to read:");
        String noteName = scanner.nextLine();
        File noteFile = new File(folderName + "/" + noteName + ".txt");

        if (!noteFile.exists()) {
            System.out.println("Note not found!");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(noteFile))) {
            System.out.println("Note Content:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the note: " + e.getMessage());
        }
    }
}