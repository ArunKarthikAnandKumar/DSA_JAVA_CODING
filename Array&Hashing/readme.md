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