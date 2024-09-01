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
