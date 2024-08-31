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
