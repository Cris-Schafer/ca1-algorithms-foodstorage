package ca1;

import java.util.Scanner;

public class CA1 {

    private static final Scanner scanner = new Scanner(System.in);
    private static final FoodStorageDeque storage = new FoodStorageDeque();

    public static void main(String[] args) {
        int choice;

        do {
            printMenu();
            choice = readMenuChoice();

            switch (choice) {
                case 1 -> System.out.println("Add food item - coming soon.");
                case 2 -> System.out.println("Remove food item - coming soon.");
                case 3 -> System.out.println("Show item at the front - coming soon.");
                case 4 -> System.out.println("Display all items - coming soon.");
                case 5 -> System.out.println("Search food item - coming soon.");
                case 6 -> System.out.println("Closing the storage application. Goodbye!");
                default -> System.out.println("Please choose a number between 1 and 6.");
            }
        } while (choice != 6);

        scanner.close();
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("===== Food Storage Menu =====");
        System.out.println("1. Add food item");
        System.out.println("2. Remove food item");
        System.out.println("3. Show item at the front");
        System.out.println("4. Display all items");
        System.out.println("5. Search food item by name");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }

    private static int readMenuChoice() {
        String input = scanner.nextLine().trim();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
