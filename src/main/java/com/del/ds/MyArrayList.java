package com.del.ds;

public class MyArrayList<T> {

    private Object[] data;
    private int size;

    public MyArrayList() {
    }

    public MyArrayList(int initialCapacity) {
    }

    public void add(T value) {
    }

    public void add(int index, T value) {
    }

    public T get(int index) {
        return null;
    }

    public T set(int index, T value) {
        return null;
    }

    public T remove(int index) {
        return null;
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public int indexOf(T value) {
        return -1;
    }

    public boolean contains(T value) {
        return false;
    }

    public void clear() {
    }

    @Override
    public String toString() {
        return "";
    }

    private void grow() {
    }

    // valid indices: 0..size-1 (get, set, remove)
    private void checkIndex(int index) {
    }

    // valid indices: 0..size (add at index)
    private void checkPositionIndex(int index) {
    }
}
