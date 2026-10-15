package ca1;

import java.time.LocalDate;

public class CA1 {

    private static final ConsoleInput input = new ConsoleInput();
    private static final FoodStorageDeque storage = new FoodStorageDeque();

    public static void main(String[] args) {
        int choice;

        do {
            printMenu();
            choice = input.readInt();

            switch (choice) {
                case 1 -> handleAddItem();
                case 2 -> handleRemoveItem();
                case 3 -> handlePeekFront();
                case 4 -> handleDisplayAll();
                case 5 -> handleSearch();
                case 6 -> System.out.println("Closing the storage application. Goodbye!");
                default -> System.out.println("Please choose a number between 1 and 6.");
            }
        } while (choice != 6);

        input.close();
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

    private static void handleAddItem() {
        if (storage.isFull()) {
            System.out.println("Storage is full (capacity 8). Remove an item before adding another.");
            return;
        }

        System.out.println();
        System.out.println("1. Burger 🍔  2. Pizza 🍕  3. Fries 🍟  4. Sandwich 🥪  5. Hotdog 🌭");
        System.out.print("Choose the food type: ");
        int typeChoice = input.readInt();

        System.out.print("Food name (e.g. Cheese Burger): ");
        String name = input.readText();

        System.out.print("Weight in grams: ");
        double weight = input.readWeight();

        System.out.print("Best-before date (yyyy-mm-dd): ");
        LocalDate bestBeforeDate = input.readBestBeforeDate();

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

    private static void handleRemoveItem() {
        if (storage.isEmpty()) {
            System.out.println("Storage is empty. Nothing to remove.");
            return;
        }

        System.out.println();
        System.out.println("1. Remove from the front (stack mode)");
        System.out.println("2. Remove from the rear (queue mode)");
        System.out.print("Choose the removal mode: ");
        int modeChoice = input.readInt();

        FoodItem removed;
        switch (modeChoice) {
            case 1 -> removed = storage.removeFront();
            case 2 -> removed = storage.removeRear();
            default -> {
                System.out.println("Please choose 1 or 2.");
                return;
            }
        }

        System.out.println("Removed: " + removed);
    }

    private static void handlePeekFront() {
        if (storage.isEmpty()) {
            System.out.println("Storage is empty.");
            return;
        }

        System.out.println("At the front: " + storage.peekFront());
    }

    private static void handleDisplayAll() {
        if (storage.isEmpty()) {
            System.out.println("Storage is empty.");
            return;
        }

        System.out.println();
        System.out.println("Front to rear:");
        int position = 1;
        for (FoodItem item : storage.displayAll()) {
            System.out.println(position + ". " + item);
            position++;
        }
    }

    private static void handleSearch() {
        if (storage.isEmpty()) {
            System.out.println("Storage is empty.");
            return;
        }

        System.out.print("Food name to search: ");
        String name = input.readText();

        FoodItem found = storage.search(name);
        if (found == null) {
            System.out.println("No item named \"" + name + "\" was found.");
        } else {
            System.out.println("Found: " + found);
        }
    }
}
