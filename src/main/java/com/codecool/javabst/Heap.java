package com.codecool.javabst;

import java.util.Arrays;

public class Heap {

    private int capacity = 15;
    private int size = 0;

    int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex) { return 2 * parentIndex + 1;}
    private int getRightChildIndex(int parentIndex) { return 2 * parentIndex + 2;}
    private int getParentIndex(int childIndex) { return (childIndex - 1) / 2;}

    private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < size;}
    private boolean hasRightChild(int index) { return getRightChildIndex(index) < size;}
    private boolean hasParent(int index) { return getParentIndex(index) >= 0;}

    private int LeftChild(int index) { return items[getLeftChildIndex(index)];}
    private int RightChild(int index) { return items[getRightChildIndex(index)] ;}
    private int Parent(int index) { return items[getParentIndex(index)];}

    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2 + 1);
            capacity *= 2;
        }
    }

    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }

    public int poll() {
        if (size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(int item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
    }

    private void heapifyDown() {
    }
}
