package com.del.ds;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Assumed API (ArrayList<T>):
 *   ArrayList()                 ArrayList(int initialCapacity)
 *   void add(T value)              void add(int index, T value)
 *   T get(int index)               T set(int index, T value)   // returns old value
 *   T remove(int index)            // returns removed value
 *   int size()                     boolean isEmpty()
 * Bad indices throw IndexOutOfBoundsException; a negative capacity throws
 * IllegalArgumentException. Null elements are allowed.
 */
public class ArrayListTest {

    private ArrayList<Integer> arr;

    @BeforeEach
    void setUp() {
        arr = new ArrayList<>();
    }

    private void fill(int n) {
        for (int i = 0; i < n; i++) {
            arr.add(i);
        }
    }

    // ---- construction ----

    @Test
    void newArrayIsEmpty() {
        assertEquals(0, arr.size());
        assertTrue(arr.isEmpty());
    }

    @Test
    void negativeCapacityRejected() {
        assertThrows(IllegalArgumentException.class, () -> new ArrayList<Integer>(-1));
    }

    @Test
    void zeroCapacityStillGrows() {
        ArrayList<Integer> a = new ArrayList<>(0);
        for (int i = 0; i < 10; i++) {
            a.add(i);
        }
        assertEquals(10, a.size());
        assertEquals(9, a.get(9));
    }

    @Test
    void capacityOneGrows() {
        ArrayList<Integer> a = new ArrayList<>(1);
        for (int i = 0; i < 100; i++) {
            a.add(i);
        }
        assertEquals(100, a.size());
        for (int i = 0; i < 100; i++) {
            assertEquals(i, a.get(i));
        }
    }

    // ---- add / get ----

    @Test
    void addAppendsInOrder() {
        arr.add(10);
        arr.add(20);
        arr.add(30);
        assertEquals(3, arr.size());
        assertFalse(arr.isEmpty());
        assertEquals(10, arr.get(0));
        assertEquals(20, arr.get(1));
        assertEquals(30, arr.get(2));
    }

    @Test
    void growthPreservesAllElements() {
        fill(1000);
        assertEquals(1000, arr.size());
        for (int i = 0; i < 1000; i++) {
            assertEquals(i, arr.get(i));
        }
    }

    @Test
    void getOutOfBoundsThrows() {
        fill(3);
        assertThrows(IndexOutOfBoundsException.class, () -> arr.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> arr.get(3));
        assertThrows(IndexOutOfBoundsException.class, () -> arr.get(100));
    }

    @Test
    void getOnEmptyThrows() {
        assertThrows(IndexOutOfBoundsException.class, () -> arr.get(0));
    }

    @Test
    void getRejectsIndexInSpareCapacity() {
        // capacity is larger than size, but only indices < size are valid
        ArrayList<Integer> a = new ArrayList<>(10);
        a.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> a.get(1));
    }

    // ---- set ----

    @Test
    void setReplacesAndReturnsOldValue() {
        fill(3);
        assertEquals(1, arr.set(1, 99));
        assertEquals(99, arr.get(1));
        assertEquals(3, arr.size());
    }

    @Test
    void setOutOfBoundsThrows() {
        fill(3);
        assertThrows(IndexOutOfBoundsException.class, () -> arr.set(-1, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> arr.set(3, 0));
    }

    // ---- insert at index ----

    @Test
    void insertAtFrontShiftsRight() {
        fill(3); // 0 1 2
        arr.add(0, 99);
        assertEquals(4, arr.size());
        assertEquals(99, arr.get(0));
        assertEquals(0, arr.get(1));
        assertEquals(1, arr.get(2));
        assertEquals(2, arr.get(3));
    }

    @Test
    void insertInMiddle() {
        fill(4); // 0 1 2 3
        arr.add(2, 99);
        assertEquals(5, arr.size());
        assertEquals(0, arr.get(0));
        assertEquals(1, arr.get(1));
        assertEquals(99, arr.get(2));
        assertEquals(2, arr.get(3));
        assertEquals(3, arr.get(4));
    }

    @Test
    void insertAtSizeBehavesLikeAppend() {
        fill(3);
        arr.add(3, 99);
        assertEquals(4, arr.size());
        assertEquals(99, arr.get(3));
    }

    @Test
    void insertIntoEmptyAtZero() {
        arr.add(0, 5);
        assertEquals(1, arr.size());
        assertEquals(5, arr.get(0));
    }

    @Test
    void insertOutOfBoundsThrows() {
        fill(3);
        assertThrows(IndexOutOfBoundsException.class, () -> arr.add(-1, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> arr.add(4, 0)); // size + 1
    }

    @Test
    void insertWhenFullTriggersGrowthAndKeepsOrder() {
        ArrayList<Integer> a = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            a.add(i); // exactly full
        }
        a.add(0, 99);
        assertEquals(5, a.size());
        assertEquals(99, a.get(0));
        for (int i = 0; i < 4; i++) {
            assertEquals(i, a.get(i + 1));
        }
    }

    // ---- remove ----

    @Test
    void removeFromFrontShiftsLeft() {
        fill(4); // 0 1 2 3
        assertEquals(0, arr.remove(0));
        assertEquals(3, arr.size());
        assertEquals(1, arr.get(0));
        assertEquals(2, arr.get(1));
        assertEquals(3, arr.get(2));
    }

    @Test
    void removeFromMiddle() {
        fill(5);
        assertEquals(2, arr.remove(2));
        assertEquals(4, arr.size());
        assertEquals(0, arr.get(0));
        assertEquals(1, arr.get(1));
        assertEquals(3, arr.get(2));
        assertEquals(4, arr.get(3));
    }

    @Test
    void removeLast() {
        fill(3);
        assertEquals(2, arr.remove(2));
        assertEquals(2, arr.size());
        assertThrows(IndexOutOfBoundsException.class, () -> arr.get(2));
    }

    @Test
    void removeOnlyElementLeavesEmpty() {
        arr.add(7);
        assertEquals(7, arr.remove(0));
        assertTrue(arr.isEmpty());
        assertEquals(0, arr.size());
    }

    @Test
    void removeOutOfBoundsThrows() {
        fill(3);
        assertThrows(IndexOutOfBoundsException.class, () -> arr.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> arr.remove(3));
    }

    @Test
    void removeOnEmptyThrows() {
        assertThrows(IndexOutOfBoundsException.class, () -> arr.remove(0));
    }

    @Test
    void removedSlotIsNotReadableAfterShrink() {
        fill(3);
        arr.remove(0);
        // stale data in the old last slot must not be reachable
        assertThrows(IndexOutOfBoundsException.class, () -> arr.get(2));
    }

    // ---- reuse after shrinking ----

    @Test
    void addAfterRemoveReusesSpace() {
        fill(3);
        arr.remove(2);
        arr.add(50);
        assertEquals(3, arr.size());
        assertEquals(50, arr.get(2));
    }

    @Test
    void drainThenRefill() {
        fill(100);
        while (!arr.isEmpty()) {
            arr.remove(arr.size() - 1);
        }
        assertEquals(0, arr.size());
        fill(50);
        assertEquals(50, arr.size());
        assertEquals(49, arr.get(49));
    }

    @Test
    void repeatedFrontRemovalDrainsInOrder() {
        fill(20);
        for (int i = 0; i < 20; i++) {
            assertEquals(i, arr.remove(0));
        }
        assertTrue(arr.isEmpty());
    }

    // ---- nulls ----

    @Test
    void storesNullElements() {
        ArrayList<String> s = new ArrayList<>();
        s.add("a");
        s.add(null);
        s.add("c");
        assertNull(s.get(1));
        assertEquals(3, s.size());
        assertNull(s.remove(1));
        assertEquals("c", s.get(1));
    }

    // ---- independence ----

    @Test
    void instancesDoNotShareState() {
        ArrayList<Integer> other = new ArrayList<>();
        arr.add(1);
        other.add(2);
        other.add(3);
        assertEquals(1, arr.size());
        assertEquals(2, other.size());
    }
}
