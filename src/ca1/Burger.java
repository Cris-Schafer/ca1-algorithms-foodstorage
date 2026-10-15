package ca1;

import java.time.LocalDate;

public class Burger extends FoodItem {

    public Burger(String name, double weightGrams, LocalDate bestBeforeDate) {
        super("Burger", name, weightGrams, bestBeforeDate);
    }
}
