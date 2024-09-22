# 440. K-th Smallest in Lexicographical Order
Solved
Hard
Topics
Companies
Given two integers n and k, return the kth lexicographically smallest integer in the range [1, n].

 

Example 1:

Input: n = 13, k = 2
Output: 10
Explanation: The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
Example 2:

Input: n = 1, k = 1
Output: 1

```
class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1; // Start from the smallest lexicographical number
        k--; // Decrease k because we are considering the first number

        while (k > 0) {
            int steps = countSteps(n, curr, curr + 1); // Count numbers between curr and curr + 1
            if (steps <= k) {
                // Move to the next prefix (curr + 1)
                curr++;
                k -= steps;
            } else {
                // Go deeper in the current prefix (curr * 10)
                curr *= 10;
                k--; // We are considering one number (curr) in this step
            }
        }
        return curr;
    }

    // This method counts how many numbers exist between `prefix` and `prefix + 1`
    private int countSteps(int n, long prefix, long nextPrefix) {
        int steps = 0;
        while (prefix <= n) {
            steps += Math.min(n + 1, nextPrefix) - prefix; // Count numbers between prefix and nextPrefix
            prefix *= 10; // Go deeper (e.g., from 1 -> 10, 100, etc.)
            nextPrefix *= 10;
        }
        return steps;
    }
}

```