package ca1;

import java.time.LocalDate;

public class Burger extends FoodItem {

    public Burger(double weightGrams, LocalDate bestBeforeDate) {
        super("Burger", weightGrams, bestBeforeDate);
    }
}
