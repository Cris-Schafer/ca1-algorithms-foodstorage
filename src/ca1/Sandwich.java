package ca1;

import java.time.LocalDate;

public class Sandwich extends FoodItem {

    public Sandwich(String name, double weightGrams, LocalDate bestBeforeDate) {
        super("Sandwich", name, weightGrams, bestBeforeDate);
    }
}
