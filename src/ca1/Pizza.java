package ca1;

import java.time.LocalDate;

public class Pizza extends FoodItem {

    public Pizza(String name, double weightGrams, LocalDate bestBeforeDate) {
        super("Pizza", name, weightGrams, bestBeforeDate);
    }
}
