# HasHing Theory
To count Frequency of Numbers of Fixed Length:
### Number Hashing
```
 int[] hash = new int[13];
        for (int i = 0; i < n; i++) {
            hash[arr[i]] += 1;
        }
```
### Character Hashing

Lower case
```
 int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
```
Both Upper and lower

```
 //precompute:
        int[] hash = new int[256];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
        }
```

 ```
 //precompute:
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = arr[i];
            int freq = 0;
            if (mp.containsKey(key)) freq = mp.get(key); // fetching from the map
            freq++;
            or 
            hm.put(hm.getOrDefault(c,0)+1);
            mp.put(key, freq); // inserting into the map
        }

```
# What is collision & How the hashing works:
Hashing is done using several methods. Among them, the three most common ones are

- Division method
- Folding method
- Mid-Square method


# Duplicate Integer
 
Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.

```
Example 1:

Input: nums = [1, 2, 3, 3]

Output: true
```
```
Example 2:

Input: nums = [1, 2, 3, 4]

Output: false
```
```
import java.util.*;
class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        for(int n:nums){
            if(hs.contains(n)){
                return true;
            }else{
                hs.add(n);
            }
        }
        return false;
    }
}

```

# Is Anagram

Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.

An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

```
Example 1:

Input: s = "racecar", t = "carrace"

Output: true
```
```
Example 2:

Input: s = "jar", t = "jam"

Output: false
Constraints:
```
s and t consist of lowercase English letters.

```
import java.util.*;
//M1 using HasHamp
class Solution1 {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> h1=new HashMap<>();
        HashMap<Character,Integer> h2=new HashMap<>();
        for(char c:s.toCharArray()){
            h1.put(c,h1.getOrDefault(c,0)+1);
        }
        for(char c:t.toCharArray()){
            h2.put(c,h2.getOrDefault(c,0)+1);
        }
        return h1.equals(h2);
    }
}

//M2 using array only
class Solution {
    public boolean isAnagram(String s, String t) {
        int []st=new int[26];
        int n1=s.length();
        int n2=t.length();
        if(n1!=n2){
            return false;
        }
        for(int i=0;i<n1;i++){
            st[s.charAt(i)-'a']++;
            st[t.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(st[i]>0){
                return false;
            }
        }
        return true;
    }
}

```
# Group Anagram
```
import java.util.*;
class Solution {
    
    public List<List<String>> groupAnagrams(String[] strs) {
       HashMap<String,List<String>> h=new HashMap();
       for(String s:strs){
        char [] charArray=s.toCharArray();
        	
        String sorted=new String(charArray);
        if(!h.containsKey(sorted)){
            h.put(sorted,new ArrayList<>());
        }
        h.get(sorted).add(s);

       }
         List<List<String>> result = new ArrayList<>(h.values());
       return result;
     
}
}
```


# Two Integer Sum

Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.

You may assume that every input has exactly one pair of indices i and j that satisfy the condition.

Return the answer with the smaller index first.

```Example 1:

Input: 
nums = [3,4,5,6], target = 7

Output: [0,1]
Explanation: nums[0] + nums[1] == 7, so we return [0, 1].
```
```Example 2:

Input: nums = [4,5,6], target = 10

Output: [0,2]
Example 3:

Input: nums = [5,5], target = 10

Output: [0,1]
```

```
import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int cur=nums[i];
            int diff=target-cur;
            if(hm.containsKey(diff)){
                return new int[]{hm.get(diff),i};
            }
            hm.put(cur,i);
        }
        return new int[]{};
        
    }
}
```

# Buy and Sell Stock
You are given an integer array prices where prices[i] is the price of NeetCoin on the ith day.
You may choose a single day to buy one NeetCoin and choose a different day in the future to sell it.
Return the maximum profit you can achieve. You may choose to not make any transactions, in which case the profit would be 0.
Example 1:
Input: prices = [10,1,5,6,7,1]

Output: 6
Copy
Explanation: Buy prices[1] and sell prices[4], profit = 7 - 1 = 6.
Example 2:
Input: prices = [10,8,7,5,2]

Output: 0

  
 ```
//In this instead of incerementing l by 1 put l in place of r
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int l=0;
        int r=1;
        int max=0;
       while( r<n){
            if(prices[l]>prices[r]){
                l=r;
            }else{
                max=Math.max(prices[r]-prices[l],max);
            }
            r++;
        }
        return max;
        
    }
}
```
	
# 122. Best Time to Buy and Sell Stock II
Companies
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
Find and return the maximum profit you can achieve.
 
Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
Example 2:
Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
Example 3:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 
Constraints:
•	1 <= prices.length <= 3 * 104
•	0 <= prices[i] <= 104

```
class Solution {
    public int maxProfit(int[] prices) {
        int l=0;
        int profit=0;
        int n=prices.length;
        for(int r=1;r<n;r++){
            if(prices[l]<prices[r]){
                profit+=prices[r]-prices[l];
                l=r;
            }else{
                l=r;
            }
        }
        return profit;
    }
}
```