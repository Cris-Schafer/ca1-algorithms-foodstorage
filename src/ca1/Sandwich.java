package ca1;

import java.time.LocalDate;

// Same idea as Burger: only the type name changes, FoodItem handles the rest.
public class Sandwich extends FoodItem {

    public Sandwich(String name, double weightGrams, LocalDate bestBeforeDate) {
        super("Sandwich", name, weightGrams, bestBeforeDate);
    }
}
