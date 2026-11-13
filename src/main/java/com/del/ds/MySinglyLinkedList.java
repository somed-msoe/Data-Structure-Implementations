package com.del.ds;

/**
 * A singly linked list. Each element lives in a {@code Node} that points to
 * the next node; the list keeps references to both the first ({@code head})
 * and last ({@code tail}) nodes so that adding at either end is O(1).
 *
 * @param <T> the type of elements stored in this list
 */
public class MySinglyLinkedList<T> {

    /**
     * A single link in the list: a value plus a pointer to the next node.
     */
    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Creates an empty list.
     */
    public MySinglyLinkedList() {
    }

    /**
     * Inserts a value at the front of the list. O(1).
     *
     * @param value the element to insert; {@code null} is allowed
     */
    public void addFirst(T value) {
    }

    /**
     * Appends a value to the end of the list. O(1) thanks to the tail reference.
     *
     * @param value the element to append; {@code null} is allowed
     */
    public void addLast(T value) {
    }

    /**
     * Appends a value to the end of the list. Equivalent to {@link #addLast}.
     *
     * @param value the element to append; {@code null} is allowed
     */
    public void add(T value) {
    }

    /**
     * Inserts a value at the given position, shifting that element and every
     * element after it one position toward the tail. Inserting at {@code size}
     * behaves like an append.
     *
     * @param index the position to insert at, from 0 to {@code size} inclusive
     * @param value the element to insert; {@code null} is allowed
     * @throws IndexOutOfBoundsException if {@code index < 0} or {@code index > size}
     */
    public void add(int index, T value) {
    }

    /**
     * Returns the element at the given position. O(n) since the list must be
     * walked from the head.
     *
     * @param index the position to read, from 0 to {@code size - 1}
     * @return the element at {@code index}
     * @throws IndexOutOfBoundsException if {@code index < 0} or {@code index >= size}
     */
    public T get(int index) {
        return null;
    }

    /**
     * Returns the first element without removing it.
     *
     * @return the element at the head of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T getFirst() {
        return null;
    }

    /**
     * Returns the last element without removing it.
     *
     * @return the element at the tail of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T getLast() {
        return null;
    }

    /**
     * Replaces the element at the given position.
     *
     * @param index the position to overwrite, from 0 to {@code size - 1}
     * @param value the new element; {@code null} is allowed
     * @return the element that was previously at {@code index}
     * @throws IndexOutOfBoundsException if {@code index < 0} or {@code index >= size}
     */
    public T set(int index, T value) {
        return null;
    }

    /**
     * Removes and returns the first element. O(1).
     *
     * @return the element that was at the head of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFirst() {
        return null;
    }

    /**
     * Removes and returns the last element. O(n) because a singly linked list
     * has no backward pointers, so the node before the tail must be found by
     * walking from the head.
     *
     * @return the element that was at the tail of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeLast() {
        return null;
    }

    /**
     * Removes the element at the given position, relinking the previous node to
     * the one after it.
     *
     * @param index the position to remove, from 0 to {@code size - 1}
     * @return the element that was removed
     * @throws IndexOutOfBoundsException if {@code index < 0} or {@code index >= size}
     */
    public T remove(int index) {
        return null;
    }

    /**
     * Removes the first occurrence of a value, if present.
     *
     * @param value the value to remove; {@code null} may be searched for
     * @return {@code true} if an element was removed, {@code false} if the value was not found
     */
    public boolean remove(T value) {
        return false;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements currently stored
     */
    public int size() {
        return 0;
    }

    /**
     * Returns whether the list holds no elements.
     *
     * @return {@code true} if {@code size} is 0
     */
    public boolean isEmpty() {
        return false;
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
     * Reverses the list in place by flipping every node's {@code next} pointer,
     * then swapping {@code head} and {@code tail}. O(n) time, O(1) extra space.
     */
    public void reverse() {
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
     * Guard for operations on an existing element ({@code get}, {@code set},
     * {@code remove}). Valid indices are 0 to {@code size - 1}.
     *
     * @param index the index to validate
     * @throws IndexOutOfBoundsException if the index is outside that range
     */
    private void checkIndex(int index) {
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
    }
}
