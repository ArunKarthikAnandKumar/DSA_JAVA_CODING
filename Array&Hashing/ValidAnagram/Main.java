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

