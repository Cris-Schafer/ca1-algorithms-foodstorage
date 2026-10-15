package ca1;

import java.util.List;

public interface StorageOperations {

    void addFront(FoodItem item);

    FoodItem removeFront();

    FoodItem removeRear();

    FoodItem peekFront();

    List<FoodItem> displayAll();

    FoodItem search(String name);

    boolean isEmpty();

    boolean isFull();

    int size();
}
