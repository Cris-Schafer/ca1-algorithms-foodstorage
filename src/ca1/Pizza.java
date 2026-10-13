package ca1;

import java.time.LocalDate;

public class Pizza extends FoodItem {

    public Pizza(double weightGrams, LocalDate bestBeforeDate) {
        super("Pizza", weightGrams, bestBeforeDate);
    }

    @Override
    public int getMaxShelfLifeDays() {
        return 4;
    }
}
