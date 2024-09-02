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