package ca1;

import java.time.LocalDate;

// Same idea as Burger: only the type name changes, FoodItem handles the rest.
public class Hotdog extends FoodItem {

    public Hotdog(String name, double weightGrams, LocalDate bestBeforeDate) {
        super("Hotdog", name, weightGrams, bestBeforeDate);
    }
}
