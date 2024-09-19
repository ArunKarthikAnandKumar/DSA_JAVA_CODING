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


# For checking based on count 2 methods
 - 1 Using HashMap 
 - 2 Using ArrayTo count Occurence

 # While printing in for loop instead of using break can use return

 # Container with max water
 Concept 
 2 pointer approach one for left and another for right
 increment if height{l}< height(r)
 claculate inital 
 ```
 class Solution {
    public int maxArea(int[] heights) {
        int l=0;
        int r=heights.length-1;
        int max=Integer.MIN_VALUE;
        while(l<r){
            int area=Math.min(heights[l],heights[r]) *(r-l);
            max=Math.max(area,max);
            if(heights[l]<heights[r]){
                l++;
            }
            else if(heights[l]>heights[r]){
                r--;;
            }else{
                r--;
            }

        }
        return max;
        
    }
}

 ```

 # Minimum merger opeartions to palindrome
 2 pointer
 if not same increment value of left or right based on value

 ```
 import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Size of the array
        
        if (n <= 0) {
            System.out.println(0);
            return;
        }
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int result = minMergeOperations(arr);
        System.out.println(result);
    }
    
    private static int minMergeOperations(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int mergeCount = 0;
        
        while (left < right) {
            if (arr[left] == arr[right]) {
                left++;
                right--;
            } else if (arr[left] < arr[right]) {
                left++;
                arr[left] += arr[left - 1];
                mergeCount++;
            } else {
                right--;
                arr[right] += arr[right + 1];
                mergeCount++;
            }
        }
        
        return mergeCount;
    }
}

 ```

 # sliding window
 Main concept dont recalculate for all ,first calculate for window sizee
 then add and subtract
 ```
 import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Reading input for number of days (N) and consecutive days (K)
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        int[] sales = new int[N];
        // Reading the sales revenue for each day
        for (int i = 0; i < N; i++) {
            sales[i] = sc.nextInt();
        }
        
        // Finding the maximum revenue for any continuous period of K days
        int maxRevenue = findMaxRevenue(sales, N, K);
        
        // Output the maximum revenue
        System.out.println(maxRevenue);
    }
    
    private static int findMaxRevenue(int[] sales, int N, int K) {
        // Calculate the sum for the first window of K days
        int currentSum = 0;
        for (int i = 0; i < K; i++) {
            currentSum += sales[i];
        }
        
        int maxSum = currentSum;  // Initialize maxSum to the first window sum
        
        // Slide the window across the sales array
        for (int i = K; i < N; i++) {
            // Move the window: subtract the first element of the previous window and add the next element
            currentSum = currentSum - sales[i - K] + sales[i];
            // Update maxSum if the current window sum is greater
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}

 ```

 # Rotating array
 
 logic 1 to rotate in right side
 reverse whole array
 reverse left till k-1
 revers right k till n;

 for rotate acw
  reverse left till k-1
 revers right k till n;
  reverse whole array