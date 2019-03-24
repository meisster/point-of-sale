import product.Product;
import product.ProductDatabase;
import scanner.BarCodeScanner;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Menu {

    private static Scanner input = new Scanner(System.in);

    private static void printMenu(){
        System.out.println("---------------------------------------------------------------\n");
        System.out.println("Choose your option: \n" +
                                   "1 -- Scan a product\n" +
                                   "2 -- Get a receipt and pay\n" +
                                   "3 -- Exit\n"
                );
        System.out.println("---------------------------------------------------------------\n");
        System.out.print("Enter your option: ");
    }

    static void start(){
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

        boolean work = true;

        int option;

        while(work){
            option = menu();
            switch(option){
                case 1:
                    scanProduct();
                    break;
                case 2:
                    BarCodeScanner.getInstance().getReceipt();
                    System.out.println("Press a key to return...");
                    input.nextLine();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    work = false;
                    break;
                default:
                    work = false;
                    break;
            }
        }



    }

    private static int validateIntegerInput(int down, int up){
        int option;
        do {
            while (!input.hasNextInt()){
                printMenu();
                input.next();
            }
            option = input.nextInt();
        }while(option <= down || option > up);

        return option;
    }
    private static void scanProduct(){
        System.out.println("---------------------------------------------------------------\n");
        System.out.println("1 -- Scan a random product from database");
        System.out.println("2 -- Enter a code manually");
        System.out.println("---------------------------------------------------------------\n");
        System.out.print("Enter your option: ");
        int option = validateIntegerInput(0, 3);
        switch(option){
            case 1:
                BarCodeScanner.getInstance().scanProduct(ProductDatabase.getINSTANCE().getRandomProduct().getID());
                break;
            case 2:
                System.out.println("Three example products from database: ");
                IntStream.range(0, 3)
                         .forEach(n -> {
                                Product product = ProductDatabase.getINSTANCE().getRandomProduct();
                                System.out.println(String.format("%s \n ID: %d \n Price: %.2f", product.getName(), product.getID(),
                                                   product.getPrice().doubleValue()));
                });
                System.out.print("Enter product ID: ");
                long productID = validateIntegerInput(Integer.MIN_VALUE, Integer.MAX_VALUE);
                BarCodeScanner.getInstance().scanProduct(productID);
            default: break;
        }

    }



    static int menu() {

        printMenu();

        return validateIntegerInput(0, 3);
    }


}
