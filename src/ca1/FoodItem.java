package ca1;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Base type for every tray that can sit in the storage unit.
 * Holds the data the brief asks every item to carry (weight, best-before
 * date, time placed) and the one validation rule that applies to all of
 * them: a best-before date at most 14 days from today.
 */
public abstract class FoodItem {

    private static final int MAX_SHELF_LIFE_DAYS = 14;

    private final String name;
    private final double weightGrams;
    private final LocalDate bestBeforeDate;
    private final LocalDateTime timePlaced;

    protected FoodItem(String name, double weightGrams, LocalDate bestBeforeDate) {
        if (weightGrams <= 0) {
            throw new IllegalArgumentException("Weight must be greater than 0 grams.");
        }
        if (bestBeforeDate == null) {
            throw new IllegalArgumentException("Best-before date is required.");
        }

        LocalDate today = LocalDate.now();
        if (bestBeforeDate.isBefore(today)) {
            throw new IllegalArgumentException("Best-before date cannot be in the past.");
        }
        if (bestBeforeDate.isAfter(today.plusDays(MAX_SHELF_LIFE_DAYS))) {
            throw new IllegalArgumentException(
                    name + " cannot have a best-before date more than "
                    + MAX_SHELF_LIFE_DAYS + " day(s) from today.");
        }

        this.name = name;
        this.weightGrams = weightGrams;
        this.bestBeforeDate = bestBeforeDate;
        this.timePlaced = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public double getWeightGrams() {
        return weightGrams;
    }

    public LocalDate getBestBeforeDate() {
        return bestBeforeDate;
    }

    public LocalDateTime getTimePlaced() {
        return timePlaced;
    }

    @Override
    public String toString() {
        return String.format("%-10s | %7.1f g | best-before %s | placed %s",
                name, weightGrams, bestBeforeDate, timePlaced.toLocalTime().withNano(0));
    }
}
