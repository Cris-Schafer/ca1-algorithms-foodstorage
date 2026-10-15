package ca1;

import java.util.ArrayList;
import java.util.List;

public class FoodStorageDeque implements StorageOperations {

    private static final int CAPACITY = 8;

    private static class Node {
        private final FoodItem item;
        private Node prev;
        private Node next;

        private Node(FoodItem item) {
            this.item = item;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    @Override
    public void addFront(FoodItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Food item cannot be null.");
        }
        if (isFull()) {
            throw new IllegalStateException("Storage is full (capacity " + CAPACITY + ").");
        }

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

        Node removed = front;
        front = front.next;
        if (front != null) {
            front.prev = null;
        } else {
            rear = null;
        }
        size--;
        return removed.item;
    }

    @Override
    public FoodItem removeRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Storage is empty.");
        }

        Node removed = rear;
        rear = rear.prev;
        if (rear != null) {
            rear.next = null;
        } else {
            front = null;
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
