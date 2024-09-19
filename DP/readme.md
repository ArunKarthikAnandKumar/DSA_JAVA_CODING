# Minimum steps to Reach top
```
  public int minStepsToReachTop(int N, int M) {
        // If M is 0, Alice can only climb 1 step at a time
        if (M == 0) return N;
        
        // Number of M-steps Alice can take
        int stepsM = N / M;
        // Remaining steps after using M-steps
        int remainingSteps = N % M;
        
        // Total minimum steps needed
        return stepsM + remainingSteps;
    }
```

variation 1 or 2 steps at a time:
```
class stairs {
    // A simple recursive program to find
    // n'th fibonacci number
    static int fib(int n)
    {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    // Returns number of ways to reach s'th stair
    static int countWays(int s) { return fib(s + 1); }

} /* This code is contributed by Rajat Mishra */

```

# There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

 

Example 1:

'''
Input: m = 3, n = 7
Output: 28
'''
'''
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
'''

# Minmum,Maximum ,No of Ways
it is Dynamic Programing

You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days. Each day is an integer from 1 to 365.

Train tickets are sold in three different ways:

a 1-day pass is sold for costs[0] dollars,
a 7-day pass is sold for costs[1] dollars, and
a 30-day pass is sold for costs[2] dollars.
The passes allow that many days of consecutive travel.

For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
Return the minimum number of dollars you need to travel every day in the given list of days.

 
```
Example 1:

Input: days = [1,4,6,7,8,20], costs = [2,7,15]
Output: 11
Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
In total, you spent $11 and covered all the days of your travel.
```
```
Example 2:

Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
Output: 17
Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
In total, you spent $17 and covered all the days of your travel.
```

CODE:
Code Explanation:
Method Signature:

The method mincostTickets takes two input parameters:
days[]: an array of integers representing the days of the year on which the person plans to travel.
costs[]: an array of integers representing the cost of three different passes (1-day, 7-day, and 30-day).
Variable Initialization:

lastDay: Stores the last day of travel, i.e., the last element in the days array.
dp[]: An array to store the minimum travel cost for each day up to lastDay. The size of dp[] is lastDay + 1 to accommodate all possible days from 0 to lastDay.
dp[i] will represent the minimum cost to cover travel up to day i.
Base case: dp[0] = 0, meaning no cost is incurred when there are no travel days.
Main Logic:

The code loops through all days from 1 to lastDay. For each day i, it checks if it's a travel day (i.e., a day present in the days[] array).
Non-Travel Day:

If the current day i is not in days[] (determined by the contains method), the minimum cost on that day will be the same as the previous day (dp[i-1]), because there’s no need to purchase any pass.
Travel Day:

If the current day i is a travel day, the minimum cost is calculated by considering the three possible options:
1-day pass: The cost of using a 1-day pass on day i is dp[i-1] + costs[0].
7-day pass: The cost of using a 7-day pass starting on day i is dp[i-7] + costs[1]. If i is less than 7, it means this 7-day pass covers all previous days, so just use costs[1].
30-day pass: Similarly, the cost of using a 30-day pass is dp[i-30] + costs[2], and if i is less than 30, the pass covers all previous days, so just use costs[2].
The minimum of these three values is chosen and stored in dp[i], ensuring that the cheapest option is always used.
Return Value:

After processing all days, the final cost for the last travel day (lastDay) is stored in dp[lastDay], which is returned as the result.

# code
```
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int last=days[days.length-1];
        int dp[]=new int[last+1];
        dp[0]=0;
        for(int i=1;i<=last;i++){
            if(!chk(days,i)){
                dp[i]=dp[i-1];
            }else{
                int cost1=dp[i-1]+costs[0];
                int cost2=(i>=7)?dp[i-7]+costs[1]:costs[1];
                int cost3=(i>=30)?dp[i-30]+costs[2]:costs[2];
                dp[i]=Math.min(cost1,Math.min(cost2,cost3));
            }
        }
        return dp[last];
    }
    static boolean chk(int arr[],int i){
        for(int n:arr){
            if(i==n){
                return true;
            }
        }
        return false;
    }
}
```