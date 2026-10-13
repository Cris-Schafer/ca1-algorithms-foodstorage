package ca1;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Base type for every tray that can sit in the storage unit.
 * Holds the data the brief asks every item to carry (weight, best-before
 * date, time placed) and the validation rules that apply to all of them.
 */
public abstract class FoodItem {

    private static final int BRIEF_MAX_SHELF_LIFE_DAYS = 14;

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
        // getMaxShelfLifeDays() is abstract but safe to call here: every subclass
        // just returns a fixed constant, so it never depends on fields that
        // haven't been assigned yet.
        int maxAllowedDays = Math.min(BRIEF_MAX_SHELF_LIFE_DAYS, getMaxShelfLifeDays());

        if (bestBeforeDate.isBefore(today)) {
            throw new IllegalArgumentException("Best-before date cannot be in the past.");
        }
        if (bestBeforeDate.isAfter(today.plusDays(maxAllowedDays))) {
            throw new IllegalArgumentException(
                    name + " cannot have a best-before date more than "
                    + maxAllowedDays + " day(s) from today.");
        }

        this.name = name;
        this.weightGrams = weightGrams;
        this.bestBeforeDate = bestBeforeDate;
        this.timePlaced = LocalDateTime.now();
    }

    /** Each food type defines its own realistic shelf life (still capped at 14 days). */
    public abstract int getMaxShelfLifeDays();

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
