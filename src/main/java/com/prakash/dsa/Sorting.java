package com.prakash.dsa;

/**
 * Classic comparison-based sorting algorithms. All methods sort the array in place.
 */
public final class Sorting {

    private Sorting() {
    }

    /** Bubble sort with early exit. Time O(n^2), best case O(n). Space O(1). Stable. */
    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                return;
            }
        }
    }

    /** Insertion sort. Time O(n^2), best case O(n). Space O(1). Stable. */
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    /** Merge sort. Time O(n log n). Space O(n). Stable. */
    public static void mergeSort(int[] a) {
        if (a.length < 2) {
            return;
        }
        mergeSort(a, new int[a.length], 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int[] tmp, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort(a, tmp, lo, mid);
        mergeSort(a, tmp, mid + 1, hi);
        int i = lo, j = mid + 1, k = lo;
        while (i <= mid && j <= hi) {
            tmp[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        }
        while (i <= mid) {
            tmp[k++] = a[i++];
        }
        while (j <= hi) {
            tmp[k++] = a[j++];
        }
        System.arraycopy(tmp, lo, a, lo, hi - lo + 1);
    }

    /** Quick sort (Lomuto partition, middle pivot). Time O(n log n) avg, O(n^2) worst. Space O(log n). */
    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        swap(a, lo + (hi - lo) / 2, hi);
        int pivot = a[hi];
        int p = lo;
        for (int i = lo; i < hi; i++) {
            if (a[i] < pivot) {
                swap(a, i, p++);
            }
        }
        swap(a, p, hi);
        quickSort(a, lo, p - 1);
        quickSort(a, p + 1, hi);
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
