package com.del.ds;

/**
 * A resizable array-backed list. Elements live in a plain {@code Object[]}
 * whose length is the <em>capacity</em>; {@code size} counts how many slots
 * are actually in use. When the array fills up it is replaced by a larger one.
 *
 * @param <T> the type of elements stored in this list
 */
public class MyArrayList<T> {

    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Creates an empty list with the default initial capacity (10).
     */
    public MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Creates an empty list with the given initial capacity.
     *
     * @param initialCapacity the starting length of the backing array; 0 is allowed
     * @throws IllegalArgumentException if {@code initialCapacity} is negative
     */
    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative!");
        }
        this.elements = new Object[initialCapacity];
    }

    /**
     * Appends a value to the end of the list, growing the backing array
     * first if it is full.
     *
     * @param value the element to append; {@code null} is allowed
     */
    public void add(T value) {
        if (size >= elements.length) {
            grow();
        }
        elements[size] = value;
        size++;
    }

    /**
     * Inserts a value at the given position, shifting that element and every
     * element after it one slot to the right. Inserting at {@code size}
     * behaves like an append.
     *
     * @param index the position to insert at, from 0 to {@code size} inclusive
     * @param value the element to insert; {@code null} is allowed
     * @throws IndexOutOfBoundsException if {@code index < 0} or {@code index > size}
     */
    public void add(int index, T value) {

    }

    /**
     * Returns the element at the given position.
     *
     * @param index the position to read, from 0 to {@code size - 1}
     * @return the element at {@code index}
     * @throws IndexOutOfBoundsException if {@code index < 0} or {@code index >= size}
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) this.elements[index];
    }

    /**
     * Replaces the element at the given position.
     *
     * @param index the position to overwrite, from 0 to {@code size - 1}
     * @param value the new element; {@code null} is allowed
     * @return the element that was previously at {@code index}
     * @throws IndexOutOfBoundsException if {@code index < 0} or {@code index >= size}
     */
    @SuppressWarnings("unchecked")
    public T set(int index, T value) {
        checkIndex(index);
        T oldValue = (T) elements[index];
        elements[index] = value;
        return oldValue;
    }

    /**
     * Removes the element at the given position, shifting every later element
     * one slot to the left.
     *
     * @param index the position to remove, from 0 to {@code size - 1}
     * @return the element that was removed
     * @throws IndexOutOfBoundsException if {@code index < 0} or {@code index >= size}
     */
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        checkIndex(index);

        // save the value first: the shift below overwrites its slot, and we must return it.
        // the (T) cast is needed because elements is an Object[].
        T removedValue = (T) elements[index];

        // shift everything after index one slot to the left, going left to right so each
        // slot is read before it gets overwritten. stop at size - 1 because each pass reads
        // elements[i + 1]; with i < size, the last pass would read past the data (and out
        // of bounds when the array is exactly full).
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        // after the shift, the last used slot is a stale duplicate of the previous last
        // element. null it out (before size--, so it's still at size - 1) so the list
        // doesn't keep the object alive and cause a memory leak.
        elements[size - 1] = null;
        size--;
        return removedValue;
    }

    /**
     * Returns the number of elements in the list (not the capacity).
     *
     * @return the number of elements currently stored
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns whether the list holds no elements.
     *
     * @return {@code true} if {@code size} is 0
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Finds the first occurrence of a value.
     *
     * @param value the value to search for; {@code null} may be searched for
     * @return the index of the first match, or -1 if the value is not present
     */
    public int indexOf(T value) {
        return -1;
    }

    /**
     * Returns whether the list contains the given value.
     *
     * @param value the value to search for
     * @return {@code true} if {@link #indexOf} finds the value
     */
    public boolean contains(T value) {
        return false;
    }

    /**
     * Removes all elements. The list is empty afterwards.
     */
    public void clear() {
    }

    /**
     * Returns a readable form of the list, such as {@code [a, b, c]}.
     *
     * @return a string of the elements in order, in square brackets
     */
    @Override
    public String toString() {
        return "";
    }

    /**
     * Replaces the backing array with a larger one and copies the existing
     * elements across. {@code size} is unchanged.
     */
    private void grow() {
            /*  Double the capacity, but never go below 1. Doubling alone can't grow an
            array of length 0 (0 * 2 = 0), so Math.max guarantees the new array has
            room for at least one element.
            */

            int newCapacity = Math.max(1, elements.length * 2);
            Object[] bigger = new Object[newCapacity];

            /* for (int i = 0; i < this.size; i++) {
                //bigger[i] = this.elements[i];
               }
            */

            System.arraycopy(elements, 0, bigger, 0, size); //System.arraycopy is more efficient especially with large arrays
            this.elements = bigger;

    }

    /**
     * Guard for operations on an existing element ({@code get}, {@code set},
     * {@code remove}). Valid indices are 0 to {@code size - 1}.
     *
     * @param index the index to validate
     * @throws IndexOutOfBoundsException if the index is outside that range
     */
    private void checkIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + " \nSize: " + size);
        }
    }

    /**
     * Guard for insertion ({@code add(index, value)}). Valid indices are 0 to
     * {@code size} inclusive, because inserting just past the last element is
     * an append.
     *
     * @param index the index to validate
     * @throws IndexOutOfBoundsException if the index is outside that range
     */
    private void checkPositionIndex(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("The index is invalid!");
        }
    }
}
