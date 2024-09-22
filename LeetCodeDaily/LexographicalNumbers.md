# Lexicographical Numbers
Medium
Topics
Companies
Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.

You must write an algorithm that runs in O(n) time and uses O(1) extra space. 

 

Example 1:

Input: n = 13
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
Example 2:

Input: n = 2
Output: [1,2]

# Logic 
in this we perform dfs starting from number 1 and adding to result

```
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res=new ArrayList<>();
        for(int i=1;i<10;i++){
        dfs(n,i,res);}
        return res;

        
    }
    static void dfs(int n,int curr,List<Integer> res){
        if(curr>n){
            return;
        }
        res.add(curr);
        curr*=10;
        for(int i=0;i<10;i++){
            dfs(n,curr+i,res);
        }

    }
}
```