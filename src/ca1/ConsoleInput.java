package ca1;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleInput {

    private final Scanner scanner = new Scanner(System.in);

    public int readInt() {
        String input = scanner.nextLine().trim();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String readText() {
        return scanner.nextLine().trim();
    }

    public double readWeight() {
        String input = scanner.nextLine().trim();
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            // Falls through to FoodItem's own "weight must be > 0" check.
            return -1;
        }
    }

    public LocalDate readBestBeforeDate() {
        String input = scanner.nextLine().trim();
        try {
            return LocalDate.parse(input);
        } catch (DateTimeParseException e) {
            // Falls through to FoodItem's own "best-before date is required" check.
            return null;
        }
    }

    public void close() {
        scanner.close();
    }
}
