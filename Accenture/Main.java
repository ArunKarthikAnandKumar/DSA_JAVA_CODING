 package Accenture;
 import java.util.Arrays;
 import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int SUM(int n1, int n2) {
        char[] c1 = String.valueOf(n1).toCharArray();
        char[] c2 = String.valueOf(n2).toCharArray();
        int len1 = c1.length;
        int len2 = c2.length;
        int carry = 0;
        int carryCount = 0;
        
        // Start from the last digits and move to the front
        int i = len1 - 1;
        int j = len2 - 1;
        
        while (i >= 0 && j >= 0) {
            // Get digit from n1 or 0 if out of bounds
            int digit1 = c1[i] - '0';
            // Get digit from n2 or 0 if out of bounds
            int digit2 = c2[j] - '0';
            
            // Add digits and carry
            int sum = digit1 + digit2 + carry;
            
            // Check if there is a carry
            if (sum > 9) {
                carry = 1;
                carryCount++;
            } else {
                carry = 0;
            }
            
            i--;
            j--;
        }
        
        return carryCount;
    }

    public static void main(String[] args) {
       Scanner s =new Scanner(System.in);
        int n1=s.nextInt();
        int n2=s.nextInt();
        System.out.println(SUM(n1,n2));

    }

    
}