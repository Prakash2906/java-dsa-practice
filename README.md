# Java DSA Practice

Clean, well-commented Java solutions to classic **Data Structures & Algorithms** problems, each with time/space complexity notes and JUnit 5 tests.

![Java](https://img.shields.io/badge/Java-17-orange) ![JUnit](https://img.shields.io/badge/Tests-JUnit%205-green)

## Contents

| Topic | File | Problems |
|-------|------|----------|
| Sorting | [`Sorting.java`](src/main/java/com/prakash/dsa/Sorting.java) | Bubble, Insertion, Merge, Quick sort |
| Searching | [`Searching.java`](src/main/java/com/prakash/dsa/Searching.java) | Linear, Binary, First occurrence, Rotated array search |
| Arrays | [`ArrayProblems.java`](src/main/java/com/prakash/dsa/ArrayProblems.java) | Two Sum, Kadane's max subarray, Move zeros, Rotate array, Stock profit |
| Strings | [`StringProblems.java`](src/main/java/com/prakash/dsa/StringProblems.java) | Palindrome, Anagram, Reverse words, Longest unique substring, Valid parentheses |
| Linked Lists | [`LinkedListProblems.java`](src/main/java/com/prakash/dsa/LinkedListProblems.java) | Reverse, Middle node, Cycle detection (Floyd), Merge two sorted lists |

## Complexity Cheat Sheet

| Algorithm | Best | Average | Worst | Space |
|-----------|------|---------|-------|-------|
| Bubble sort | O(n) | O(n²) | O(n²) | O(1) |
| Insertion sort | O(n) | O(n²) | O(n²) | O(1) |
| Merge sort | O(n log n) | O(n log n) | O(n log n) | O(n) |
| Quick sort | O(n log n) | O(n log n) | O(n²) | O(log n) |
| Binary search | O(1) | O(log n) | O(log n) | O(1) |

## Run the tests

```bash
git clone https://github.com/Prakash2906/java-dsa-practice.git
cd java-dsa-practice
mvn test
```

## Roadmap

- [ ] Stacks & queues (min stack, queue using stacks)
- [ ] Trees (traversals, BST operations, height, LCA)
- [ ] Graphs (BFS, DFS, Dijkstra, topological sort)
- [ ] Dynamic programming (knapsack, LIS, LCS, coin change)

## Author

**Prakash H** · [GitHub](https://github.com/Prakash2906)
