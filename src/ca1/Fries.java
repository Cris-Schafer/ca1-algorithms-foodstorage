package ca1;

import java.time.LocalDate;

public class Fries extends FoodItem {

    public Fries(double weightGrams, LocalDate bestBeforeDate) {
        super("Fries", weightGrams, bestBeforeDate);
    }

    @Override
    public int getMaxShelfLifeDays() {
        return 2;
    }
}
