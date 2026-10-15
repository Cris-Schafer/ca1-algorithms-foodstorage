package ca1;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CA1 {

    private static final Scanner scanner = new Scanner(System.in);
    private static final FoodStorageDeque storage = new FoodStorageDeque();

    public static void main(String[] args) {
        int choice;

        do {
            printMenu();
            choice = readIntChoice();

            switch (choice) {
                case 1 -> handleAddItem();
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

    private static int readIntChoice() {
        String input = scanner.nextLine().trim();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void handleAddItem() {
        if (storage.isFull()) {
            System.out.println("Storage is full (capacity 8). Remove an item before adding another.");
            return;
        }

        System.out.println();
        System.out.println("1. Burger  2. Pizza  3. Fries  4. Sandwich  5. Hotdog");
        System.out.print("Choose the food type: ");
        int typeChoice = readIntChoice();

        System.out.print("Food name (e.g. Cheese Burger): ");
        String name = scanner.nextLine().trim();

        double weight = readWeight();
        LocalDate bestBeforeDate = readBestBeforeDate();

        try {
            FoodItem item = switch (typeChoice) {
                case 1 -> new Burger(name, weight, bestBeforeDate);
                case 2 -> new Pizza(name, weight, bestBeforeDate);
                case 3 -> new Fries(name, weight, bestBeforeDate);
                case 4 -> new Sandwich(name, weight, bestBeforeDate);
                case 5 -> new Hotdog(name, weight, bestBeforeDate);
                default -> null;
            };

            if (item == null) {
                System.out.println("Please choose a food type between 1 and 5.");
                return;
            }

            storage.addFront(item);
            System.out.println(item.getType() + ": " + item.getName() + " added to the front of the storage.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Could not add item: " + e.getMessage());
        }
    }

    private static double readWeight() {
        System.out.print("Weight in grams: ");
        String input = scanner.nextLine().trim();
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            // Falls through to FoodItem's own "weight must be > 0" check.
            return -1;
        }
    }

    private static LocalDate readBestBeforeDate() {
        System.out.print("Best-before date (yyyy-mm-dd): ");
        String input = scanner.nextLine().trim();
        try {
            return LocalDate.parse(input);
        } catch (DateTimeParseException e) {
            // Falls through to FoodItem's own "best-before date is required" check.
            return null;
        }
    }
}
