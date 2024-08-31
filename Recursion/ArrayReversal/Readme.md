# Reversal of N number
for optimized wau there are 2 Approaches:

## 1.Approach 2 pointer
one ptr at start
another ate end 
keep swapping till start<end

```
 static void reverseArray(int arr[], int n) {
      int p1 = 0, p2 = n - 1;
      while (p1 < p2) {
         int tmp = arr[p1];
         arr[p1] = arr[p2];
         arr[p2] = tmp;
         p1++;
         p2--;
      }
      printArray(arr, n);
   }
   ```

## 2.Recursive Same thing can do recursively.

```
// Source code is decompiled from a .class file using FernFlower decompiler.
package Recursion.ArrayReversal;

public class rerversal {
   public rerversal() {
   }

   static void printArray(int[] var0, int var1) {
      System.out.print("Reversed array is:- \n");

      for(int var2 = 0; var2 < var1; ++var2) {
         System.out.print(var0[var2] + " ");
      }

   }

   static void reverseArray(int[] var0, int var1, int var2) {
      if (var1 < var2) {
         int var3 = var0[var1];
         var0[var1] = var0[var2];
         var0[var2] = var3;
         reverseArray(var0, var1 + 1, var2 - 1);
      }

   }

   public static void main(String[] var0) {
      byte var1 = 5;
      int[] var2 = new int[]{5, 4, 3, 2, 1};
      reverseArray(var2, 0, var1 - 1);
      printArray(var2, var1);
   }
}
```