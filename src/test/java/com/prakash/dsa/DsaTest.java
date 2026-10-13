package com.prakash.dsa;

import com.prakash.dsa.LinkedListProblems.Node;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DsaTest {

    // ---------- Sorting ----------

    private void checkSort(Consumer<int[]> sorter) {
        Random random = new Random(42);
        for (int trial = 0; trial < 50; trial++) {
            int[] a = random.ints(random.nextInt(30), -100, 100).toArray();
            int[] expected = a.clone();
            Arrays.sort(expected);
            sorter.accept(a);
            assertArrayEquals(expected, a);
        }
    }

    @Test
    void sortingAlgorithmsMatchArraysSort() {
        checkSort(Sorting::bubbleSort);
        checkSort(Sorting::insertionSort);
        checkSort(Sorting::mergeSort);
        checkSort(Sorting::quickSort);
    }

    // ---------- Searching ----------

    @Test
    void searching() {
        int[] sorted = {1, 3, 5, 7, 9, 11};
        assertEquals(3, Searching.linearSearch(sorted, 7));
        assertEquals(-1, Searching.linearSearch(sorted, 4));
        assertEquals(4, Searching.binarySearch(sorted, 9));
        assertEquals(-1, Searching.binarySearch(sorted, 10));
        assertEquals(1, Searching.firstOccurrence(new int[]{1, 2, 2, 2, 3}, 2));
        assertEquals(-1, Searching.firstOccurrence(new int[]{1, 3}, 2));
        assertEquals(4, Searching.searchRotated(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        assertEquals(-1, Searching.searchRotated(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

    // ---------- Arrays ----------

    @Test
    void arrayProblems() {
        assertArrayEquals(new int[]{0, 1}, ArrayProblems.twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[0], ArrayProblems.twoSum(new int[]{1, 2}, 10));
        assertEquals(6, ArrayProblems.maxSubarraySum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(-1, ArrayProblems.maxSubarraySum(new int[]{-3, -1, -2}));

        int[] zeros = {0, 1, 0, 3, 12};
        ArrayProblems.moveZeros(zeros);
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, zeros);

        int[] rotate = {1, 2, 3, 4, 5, 6, 7};
        ArrayProblems.rotateRight(rotate, 3);
        assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, rotate);

        assertEquals(5, ArrayProblems.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(0, ArrayProblems.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    // ---------- Strings ----------

    @Test
    void stringProblems() {
        assertTrue(StringProblems.isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(StringProblems.isPalindrome("race a car"));
        assertTrue(StringProblems.isAnagram("listen", "silent"));
        assertFalse(StringProblems.isAnagram("rat", "car"));
        assertEquals("blue is sky the", StringProblems.reverseWords("  the sky  is blue "));
        assertEquals(3, StringProblems.longestUniqueSubstring("abcabcbb"));
        assertEquals(3, StringProblems.longestUniqueSubstring("pwwkew"));
        assertTrue(StringProblems.isBalanced("{[()()]}"));
        assertFalse(StringProblems.isBalanced("([)]"));
        assertFalse(StringProblems.isBalanced("(("));
    }

    // ---------- Linked lists ----------

    @Test
    void linkedListProblems() {
        assertArrayEquals(new int[]{4, 3, 2, 1},
                LinkedListProblems.toArray(LinkedListProblems.reverse(LinkedListProblems.of(1, 2, 3, 4))));
        assertEquals(3, LinkedListProblems.middle(LinkedListProblems.of(1, 2, 3, 4, 5)).val);
        assertEquals(4, LinkedListProblems.middle(LinkedListProblems.of(1, 2, 3, 4, 5, 6)).val);

        Node cyclic = LinkedListProblems.of(1, 2, 3);
        cyclic.next.next.next = cyclic.next;
        assertTrue(LinkedListProblems.hasCycle(cyclic));
        assertFalse(LinkedListProblems.hasCycle(LinkedListProblems.of(1, 2, 3)));

        Node merged = LinkedListProblems.mergeSorted(LinkedListProblems.of(1, 3, 5), LinkedListProblems.of(2, 4, 6));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, LinkedListProblems.toArray(merged));
    }
}
