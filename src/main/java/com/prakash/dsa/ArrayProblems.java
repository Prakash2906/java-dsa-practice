package com.prakash.dsa;

import java.util.HashMap;
import java.util.Map;

/**
 * Common array interview problems.
 */
public final class ArrayProblems {

    private ArrayProblems() {
    }

    /** Two Sum: indices of two numbers adding to target, or empty array. Hash map, O(n). */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer j = seen.get(target - nums[i]);
            if (j != null) {
                return new int[]{j, i};
            }
            seen.put(nums[i], i);
        }
        return new int[0];
    }

    /** Kadane's algorithm: maximum subarray sum. O(n) time, O(1) space. */
    public static int maxSubarraySum(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        int best = nums[0], current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            best = Math.max(best, current);
        }
        return best;
    }

    /** Moves all zeros to the end while keeping the order of non-zero elements. O(n). */
    public static void moveZeros(int[] nums) {
        int write = 0;
        for (int n : nums) {
            if (n != 0) {
                nums[write++] = n;
            }
        }
        while (write < nums.length) {
            nums[write++] = 0;
        }
    }

    /** Rotates the array right by k steps using the reversal trick. O(n) time, O(1) space. */
    public static void rotateRight(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return;
        }
        k = ((k % n) + n) % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    /** Best time to buy and sell a stock once: maximum profit. O(n). */
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, profit = 0;
        for (int p : prices) {
            minPrice = Math.min(minPrice, p);
            profit = Math.max(profit, p - minPrice);
        }
        return profit;
    }

    private static void reverse(int[] a, int i, int j) {
        while (i < j) {
            int t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }
}
