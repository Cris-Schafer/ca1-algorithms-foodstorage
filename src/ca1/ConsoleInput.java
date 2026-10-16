package ca1;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

// Reads lines from the keyboard and turns bad input (wrong format, empty
// text) into a safe value instead of letting the program crash. CA1 only
// ever sees the safe value, never the raw text or a parsing exception.
public class ConsoleInput {

    private final Scanner scanner = new Scanner(System.in);

    // Returns -1 if what was typed isn't a whole number (-1 is never a
    // valid menu option or food type, so it always falls into a "please
    // choose again" message).
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
