import exceptions.UserDataException;
import model.User;
import service.FileWriter;
import service.impl.FileWriterImpl;
import service.impl.InputConsoleReaderImpl;
import service.InputConsoleReader;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while (true) {
            Scanner scanner = new Scanner(System.in);

            InputConsoleReader inputReader = new InputConsoleReaderImpl(scanner);
            FileWriter fileWriter = new FileWriterImpl();

            try {
                User user = inputReader.readUserData();
                fileWriter.writeUserData(user);
            } catch (UserDataException | IOException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }

            System.out.println("Еще запишем? нажми \"n\" для выхода или \"enter\" для продолжения");
            scanner = new Scanner(System.in);
            if(scanner.nextLine().equalsIgnoreCase("n")) break;
        }
    }
}
