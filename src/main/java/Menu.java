import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu {
    public static int menu() {

        Scanner input = new Scanner(System.in);

        int option;

        while (true) {
            System.out.println(
                    "  _____   ____ _____ _   _ _______      ____  ______      _____         _      ______ \n" +
                            " |  __ \\ / __ \\_   _| \\ | |__   __|    / __ \\|  ____|    / ____|  /\\   | |  " +
                            "  |  ____|\n" +
                            " | |__) | |  | || | |  \\| |  | |______| |  | | |__ _____| (___   /  \\  | |    |" +
                            " |__   \n" +
                            " |  ___/| |  | || | | . ` |  | |______| |  | |  __|______\\___ \\ / /\\ \\ | |   " +
                            " |  __|  \n" +
                            " | |    | |__| || |_| |\\  |  | |      | |__| | |         ____) / ____ \\| |____|" +
                            " |____ \n" +
                            " |_|     \\____/_____|_| \\_|  |_|       \\____/|_|        |_____/_/    " +
                            "\\_\\______|______|\n" +
                            "                                                                                 " +
                            "     ");

            System.out.println("\t\t\t\t  _      ________   _________  __  _______\n" +
                                       "\t\t\t\t | | /| / / __/ /  / ___/ __ \\/  |/  / __/\n" +
                                       "\t\t\t\t | |/ |/ / _// /__/ /__/ /_/ / /|_/ / _/  \n" +
                                       "\t\t\t\t |__/|__/___/____/\\___/\\____/_/  /_/___/  \n" +
                                       "\t\t\t\t                                          ");
            System.out.println("---------------------------------------------------------------\n");
            System.out.println("Choose your option: \n" +
                                       "1 -- Add a product to system\n" +
                                       "2 -- Scan a product\n" +
                                       "3 -- Get a receipt and pay\n" +
                                       "Enter your option: ");
            try {
                option = input.nextInt();
                return option;
            } catch (InputMismatchException e) {
                System.out.println(new String(new char[50]).replace("\0", "\r\n"));
            }
        }
    }
}
