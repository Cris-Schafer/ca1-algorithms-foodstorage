package ca1;

import java.time.LocalDate;

public class Sandwich extends FoodItem {

    public Sandwich(double weightGrams, LocalDate bestBeforeDate) {
        super("Sandwich", weightGrams, bestBeforeDate);
    }
}
