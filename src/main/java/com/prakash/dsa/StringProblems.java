package com.prakash.dsa;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Common string interview problems.
 */
public final class StringProblems {

    private StringProblems() {
    }

    /** Checks if a string is a palindrome, ignoring case and non-alphanumeric characters. O(n). */
    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char a = s.charAt(i), b = s.charAt(j);
            if (!Character.isLetterOrDigit(a)) {
                i++;
            } else if (!Character.isLetterOrDigit(b)) {
                j--;
            } else if (Character.toLowerCase(a) != Character.toLowerCase(b)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    /** Checks whether two lowercase-letter strings are anagrams. O(n). */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }

    /** Reverses the order of words, collapsing extra spaces. O(n). */
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    /** Length of the longest substring without repeating characters (sliding window). O(n). */
    public static int longestUniqueSubstring(String s) {
        Map<Character, Integer> last = new HashMap<>();
        int best = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer prev = last.put(s.charAt(i), i);
            if (prev != null && prev >= start) {
                start = prev + 1;
            }
            best = Math.max(best, i - start + 1);
        }
        return best;
    }

    /** Valid parentheses: checks that (), [] and {} are balanced. Uses a stack. O(n). */
    public static boolean isBalanced(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(' -> stack.push(')');
                case '[' -> stack.push(']');
                case '{' -> stack.push('}');
                case ')', ']', '}' -> {
                    if (stack.isEmpty() || stack.pop() != c) {
                        return false;
                    }
                }
                default -> { }
            }
        }
        return stack.isEmpty();
    }
}
