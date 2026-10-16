package ca1;

import java.util.List;

// Contract for the storage: whatever class implements this has to support
// adding to the front and removing from either end (that's what lets one
// structure act like a stack or a queue depending on which remove method
// gets called).
public interface StorageOperations {

    void addFront(FoodItem item);

    // Stack mode: removes the most recently added item.
    FoodItem removeFront();

    // Queue mode: removes the oldest item still in storage.
    FoodItem removeRear();

    // Looks at the front item without removing it.
    FoodItem peekFront();

    // Returns every item, front to rear, without changing the storage.
    List<FoodItem> displayAll();

    // Returns the first item whose name matches, or null if there isn't one.
    FoodItem search(String name);

    boolean isEmpty();

    boolean isFull();

    int size();
}
