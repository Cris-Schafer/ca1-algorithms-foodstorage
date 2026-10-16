package ca1;

import java.time.LocalDate;

// Same idea as Burger: only the type name changes, FoodItem handles the rest.
public class Fries extends FoodItem {

    public Fries(String name, double weightGrams, LocalDate bestBeforeDate) {
        super("Fries", name, weightGrams, bestBeforeDate);
    }
}
