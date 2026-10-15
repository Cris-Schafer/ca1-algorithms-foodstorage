package ca1;

import java.time.LocalDate;

public class Hotdog extends FoodItem {

    public Hotdog(String name, double weightGrams, LocalDate bestBeforeDate) {
        super("Hotdog", name, weightGrams, bestBeforeDate);
    }
}
