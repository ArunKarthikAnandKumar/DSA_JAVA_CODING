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

# Cake cut Piece
#### n*(n+1)/2 +1

FOR Result mod 10^9+7
int MOD = 1000000007;

System.out.println("Ceiling of '" + d1 + "' = " + Math.ceil(d1));

System.out.println("Floor of '" + d1 + "' = " + Math.floor(d1));

A-65 Z-90
a-97 z-122