package ca1;

import java.time.LocalDate;

// One of the 5 food types from the brief. It only fixes the type name
// ("Burger"); FoodItem does all the actual validation and storage.
public class Burger extends FoodItem {

    public Burger(String name, double weightGrams, LocalDate bestBeforeDate) {
        super("Burger", name, weightGrams, bestBeforeDate);
    }
}
