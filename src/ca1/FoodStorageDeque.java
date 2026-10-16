package ca1;

import java.util.ArrayList;
import java.util.List;

// The data structure: a deque (double-ended queue) built as a doubly
// linked list. "Doubly" is the key word - each node links to both its
// neighbours, so we can reach either end directly and never have to walk
// the list just to add or remove something. That's what makes it possible
// to act as a stack (add/remove from the front) or a queue (add at the
// front, remove at the rear) with the same structure.
public class FoodStorageDeque implements StorageOperations {

    private static final int CAPACITY = 8;

    // One tray in the storage. prev/next are what make the list "doubly"
    // linked - without prev, we couldn't jump straight to the rear's
    // neighbour, and removeRear would need to walk the whole list.
    private static class Node {
        private final FoodItem item;
        private Node prev;
        private Node next;

        private Node(FoodItem item) {
            this.item = item;
        }
    }

    // front = where stack-mode removals happen (newest item).
    // rear = where queue-mode removals happen (oldest item).
    private Node front;
    private Node rear;
    private int size; // kept up to date on every add/remove, so isEmpty/isFull/size never need to count anything

    @Override
    public void addFront(FoodItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Food item cannot be null.");
        }
        if (isFull()) {
            throw new IllegalStateException("Storage is full (capacity " + CAPACITY + ").");
        }

        // Plug the new node in before the current front, then make it the
        // new front. If the storage was empty, it's also the rear.
        Node newNode = new Node(item);
        newNode.next = front;
        if (front != null) {
            front.prev = newNode;
        }
        front = newNode;
        if (rear == null) {
            rear = newNode;
        }
        size++;
    }

    @Override
    public FoodItem removeFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Storage is empty.");
        }

        // The node after the old front becomes the new front.
        Node removed = front;
        front = front.next;
        if (front != null) {
            front.prev = null;
        } else {
            rear = null; // that was the last item, so the list is empty now
        }
        size--;
        return removed.item;
    }

    @Override
    public FoodItem removeRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Storage is empty.");
        }

        // rear.prev jumps straight to the node before it - no need to
        // walk from the front. This is the whole reason removeRear is
        // just as fast (O(1)) as removeFront.
        Node removed = rear;
        rear = rear.prev;
        if (rear != null) {
            rear.next = null;
        } else {
            front = null; // that was the last item, so the list is empty now
        }
        size--;
        return removed.item;
    }

    @Override
    public FoodItem peekFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Storage is empty.");
        }
        return front.item;
    }

    @Override
    public List<FoodItem> displayAll() {
        // Walk the whole list once, front to rear, collecting every item.
        List<FoodItem> items = new ArrayList<>();
        Node current = front;
        while (current != null) {
            items.add(current.item);
            current = current.next;
        }
        return items;
    }

    @Override
    public FoodItem search(String name) {
        // Linear scan: there's no ordering to exploit, so this is the only
        // way to search - stop as soon as a name matches.
        Node current = front;
        while (current != null) {
            if (current.item.getName().equalsIgnoreCase(name)) {
                return current.item;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == CAPACITY;
    }

    @Override
    public int size() {
        return size;
    }
}
