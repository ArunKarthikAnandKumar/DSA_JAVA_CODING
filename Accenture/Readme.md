# 2 Problem Description :
The Binary number system only uses two digits, 0 and 1 and number system can be called binary string. You are required to implement the following function:

int OperationsBinaryString(char* str);

The function accepts a string str as its argument. The string str consists of binary digits eparated with an alphabet as follows:

– A denotes AND operation
– B denotes OR operation
– C denotes XOR Operation
You are required to calculate the result of the string str, scanning the string to right taking one opearation at a time, and return the same.

Note:

No order of priorities of operations is required
Length of str is odd
If str is NULL or None (in case of Python), return -1
Input:
str: 1C0C1C1A0B1

Output:
1

```
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        String st=s.next();
        int c=0;
        char res=st.charAt(c);
        for(int i=1;i<st.length();i++){
            char l=st.charAt(i);
            if(l=='A'){
                res=(char) (res & st.charAt(i+1));
            }else if(l=='B'){
                res=(char) (res | st.charAt(i+1));

            }else{
                res=(char) (res ^ st.charAt(i+1));
            }
            i++;
        }
        System.out.println(res);
    }
}
```

# Question 3: Password Checker

```
 static boolean ChkPassword(String s,int n){
        if(n<4 || Character.isDigit(s.charAt(0))){
            return false;
        }
        int num=0,cap=0;
        for(char ch:s.toCharArray()){
            if(Character.isUpperCase(ch)){
                cap++;
            }else if(Character.isDigit(ch)){
                num++;
            }else if(ch==' ' || ch=='/'){
                return false;
            }
        }
        return num>=1 && cap>=1;
    }
```

# Finding Second Smallest element
0(n)
```
 int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else if (num < secondSmallest && num != smallest) {
                secondSmallest = num;
            }
        }

```

# LEADERS IN A ARRAY
```
class Solution {
    // Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int n, int arr[]) {
        int count=1;
        ArrayList<Integer> ls=new ArrayList<>();
        ls.add(arr[n-1]);
        int max=arr[n-1];
        for(int i=n-2;i>=0;i--){
            if(arr[i]>=max){
                count++;
                max=arr[i];
                ls.add(max);
            }
        }
        Collections.reverse(ls);
        return ls;
        
    }
}
```

# Next greater Element
Ques 1. Given an array of N size, Print the Next Greater Element of every 
element.
The Next Great Element for an element x is the first greater element on the
right side of x in the array. Elements for which no greater element exist, 
consider the next greater element as -1
Input Format: Given array of N size with space separated integers.
Output: Array of size N with next greater element.
Input 1: 4 5 2 25
Output 1: 5 25 25 -1
Input 2: 5 7 1 7 6 0
Output 2: 7 -1 7 -1 -1 -1

logic stk revrse order keep poping till greater than push
```
import java.util.*;
public class Main
{
	public static void main(String[] args) {    
		int arr[]={4,5,2,25};
		int n=arr.length;
		int nge[]=new int[n];
		Stack<Integer> stk=new Stack<>();
		int max=0;
		nge[n-1]=-1;
		stk.push(arr[n-1]);
		for(int i=n-2;i>=0;i--){
		    while(!stk.isEmpty() && arr[i]>=stk.peek()){
		        stk.pop();
		    }
		    nge[i]=stk.isEmpty()?-1:stk.peek();
		    stk.push(arr[i]);
		    
		}
		System.out.println(Arrays.toString(nge));
	}
}

```

# Cake cut Piece
#### n*(n+1)/2 +1

FOR Result mod 10^9+7
int MOD = 1000000007;

System.out.println("Ceiling of '" + d1 + "' = " + Math.ceil(d1));

System.out.println("Floor of '" + d1 + "' = " + Math.floor(d1));

A-65 Z-90
a-97 z-122

# Convert all Upper or Lower based on count

# Type conversion of long answer
long ans=(long) n*(n+1)/2
mod=1000000007;
sout(ans%mod)

# Move zeros to the end
Logic: l pointer update only for non zero ,it will move adding each non zero in left most position

```
class Solution {
    public void moveZeroes(int[] nums) {
        int l=0;
        for(int r=0;r<nums.length;r++){
            if(nums[r]!=0){
                int t=nums[l];
                nums[l]=nums[r];
                nums[r]=t;
                l++;
            }
        }

    }
}
```

# Maximum Subarray
slidding window 
one variable for currSum if its negative ignore
otherwise compare with max
this is for continuous

```
class Solution {
    public int maxSubArray(int[] nums) {
        int currSum=0;
        int maxSum=nums[0];
        for(int r=0;r<nums.length;r++){
            if(currSum<0){
                currSum=0;
            }
            currSum+=nums[r];
            maxSum=Math.max(maxSum,currSum);
        }
        return maxSum;
        
    }
}
```


# Nearest Integer
Int nearestInteger(int num, int m)
The function accepts two positive ‘num’ and ‘m’ as its argument, Implement 
the following function to find the nearest integer to num.
1) Number is divisible by m.
2) Number is nearest to ‘num’ (Have the least distance from num)
Note: If there are two numbers with the least distance from num, then return 
the larger num.
Input 1: Num= 67
 M = 8
Output 1: 64

```
public class Main {
    public static int nearestInteger(int num, int m) {
        // Step 1: Find the quotient
        int quotient = num / m;

        // Step 2: Calculate the two nearest multiples of m
        int lowerMultiple = quotient * m;
        int upperMultiple = (quotient + 1) * m;

        // Step 3: Calculate distances from num
        int distLower = Math.abs(num - lowerMultiple);
        int distUpper = Math.abs(num - upperMultiple);

        // Step 4: Return the closest multiple, or the larger one if distances are equal
        if (distLower < distUpper) {
            return lowerMultiple;
        } else if (distUpper < distLower) {
            return upperMultiple;
        } else {
            // If both distances are equal, return the larger number
            return Math.max(lowerMultiple, upperMultiple);
        }
    }

    public static void main(String[] args) {
        // Test the function
        int num = 67;
        int m = 8;
        System.out.println(nearestInteger(num, m)); // Output: 64
    }
}

```


# Perfect squares

```
int sqrt = (int) Math.sqrt(num);
return (sqrt * sqrt == num);
```

# Make House of N levels
if series
sum ap sn=n/2[2*a +(n-1)*d];

# triangle house
3n^2 +n /2

# Abs difference we get when in sorted order
```
 int[] arr = { 13, 7, 6, 45, 21, 9, 101, 102 };

        // Calling the sort() method present
        // inside Arrays class
        Arrays.sort(arr);

```


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

# Happy Number
create hashset to add new sumsq value calculated if any repetn break the loop.

# Subarray 0 and 1
```
/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
		int nums[]={1,1,0,1,0};
		int zero=0,one=0;
		for(int n:nums){
		    if(n==0){
		        zero++;
		    }else{
		        one++;
		    }
		}
		int l=0,r=nums.length-1;
		int max=0;
		while(l<r){
		    int sum=0;
		    if(zero==one){
		        sum=zero+one;
		    }else{
		        if(nums[l]==0){
		            zero--;
		        }else{
		            one--;
		        }
		    }
		    l++;
		    max=Math.max(sum,max);
		    
		}
		System.out.println(max);
	}
}
```

# Magical Number 
number to binary replace 1 by 2 and 0 by 1 find usm odd or even
String Binary= Integer.toBinaryString(i);
String modified=binary.replace('0','x').replace('1','2').replace('x','1');
sum+=s.charAt(i)-'0';

# Distributing Choclate

Sort then keep sliding window of lenght number of students to fond minimum difference.

# Two sum all pair
maintain hs to check if pair exist for each and print

# Bulb Toggle

main logic for given n with n number of bulbs find the perfect square till that number,that is the answer.

# Stair Case Problem
each stem person 1 0r 2 steps.

n=1
1 posisbilty

n=2
(1,1)
(2)

n=3
(1,1,1)
(1,2) 
(2,1)

n=4
(1,1,1,1)
(2,2)
(2,1,1)
(3,1)
(1,3)

Recursion so BaseCase:
if(n==1) return 1
if(n==2) return 2

f(n)=f(n-1)+f(n-2)

# Team formation
1 experince ,1 fresh 
N expereince  M fresher
 team size 4

 therefor m*n/4 corener case val < min(resh,exxp) ok otherwisse max

 # Seating diff row and column
 nfactorial 