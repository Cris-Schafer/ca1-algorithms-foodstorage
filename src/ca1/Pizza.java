package ca1;

import java.time.LocalDate;

// Same idea as Burger: only the type name changes, FoodItem handles the rest.
public class Pizza extends FoodItem {

    public Pizza(String name, double weightGrams, LocalDate bestBeforeDate) {
        super("Pizza", name, weightGrams, bestBeforeDate);
    }
}
