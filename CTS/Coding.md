# Problem statement-: Elliot made a KeyLogger for his friend Romero, so that he can see the passwords of his friend. Keylogger is a software that can tell you the buttons pressed in the keyboard without the consent of the user, and hence unethical. Elliot made it to hack Romero’s passwords. The one problem is, Romero writes the passwords in lowercase characters only, and the keylogger only takes the values of the keys. Like, for a it takes 1, for b 2, and for z 26. For a given number Elliot produces all combinations of passwords in a dictionary and starts a dictionary based password attack. For a given number, print all the possible passwords in a lexicographic order.

Input Format:

One line, denoting the value given by the keylogger
Output Format:

All possible combinations of keyloggers in new lines are lexicographically ordered.
Constraints:

2<=Number of digit in input<=1000
Sample Input:

1234

Sample Output:

abcd

awd

lcd

Explanation:

For 12, you can take 1,2 that is ab, or you can take l.

```
import java.util.*;
class Solution
{
    static String str;
    static ArrayList < String > list = new ArrayList < String > ();
    public static void func (int i, String res)
    {
        if (i == str.length ())
        {
            list.add (res);
            return;
        }
        if (i > str.length ())
            return;
        if(str.charAt (i) == '0')
            return;
        char ch = (char) ('a' + (str.charAt (i) - '1'));

        func (i + 1, res + ch);

        if (i != str.length () - 1)
            if (str.charAt (i) < '3' && str.charAt (i + 1) < '7')
            {
                int a = (str.charAt (i) - '1' + 1), b = (str.charAt (i + 1) - '0');
                ch = (char) ('a' + (10 * a + b - 1));
                func (i + 2, res + ch);
            }
        }

        public static void main (String[]args)
        {
            Scanner sc = new Scanner (System.in);
            str = sc.next ();
            String res = "";
            func (0, res);
            Collections.sort (list);
            for (int i = 0; i < list.size (); i++)
            System.out.println (list.get (i));
        }
}
```

# Question 2
Problem Statement- Ramesh went to a bookshop to buy books. There is a list of books with their value and price. Now Ramesh has limited money but he wants maximum value possible. Now there are 2 kinds of books, one is denoted with 1, that is independent, another one is denoted as 2, which you have to buy in double, that means you can not buy a single or odd number of those books. 

Print the maximum value Ramesh can extract from the books. 

 

Input Format:

First line contains two integers, n (Number of books) and T, total money he has.
Then n lines, 4 variables in each line, 
The serial number of the book
The value of the book
The price of the book
The marking (1 or 2)
 

Output Format:

Maximum value possible to be bought.
 

Constraints:

Number of books: <=100
Maximum Money with Ramesh <=1000
Max price of a book<=1000
 

Sample Input:

5 20

1 3 7 0

3 9 10 1

2 4 3 1

7 3 2 0

22 7 7 0

Sample Output:

20

 

Explanation:

It will be the 1st book,2nd and the third book
```
import java.util.*;
class Solution 
{
    static int n, w;
    static int a[];
    static int b[];
    static int c[];
    public static int func (int i, int cb, int t, int ww)
    {
        if (i == n)
        {
            if ((cb & 1) != 0)
                return 0;
            else
                return t;
        }
        if (ww + b[i] <= w)
            return Math.max (func (i + 1, cb + c[i], t + a[i], ww + b[i]),func (i + 1, cb, t, ww));
        return func (i + 1, cb, t, ww);
    }

public static void main (String[]args)
{
    Scanner sc = new Scanner (System.in);
    n = sc.nextInt ();
    w = sc.nextInt ();
    int t;
    a = new int[n];
    b = new int[n];
    c = new int[n];

    for (int i = 0; i < n; i++){
        t = sc.nextInt ();
        a[i] = sc.nextInt ();
        b[i] = sc.nextInt ();
        c[i] = sc.nextInt ();
    }

    System.out.println (func (0, 0, 0, 0));
    }
}
```

Question 3
Problem Statement-  A taxi can take multiple passengers to the railway station at the same time.On the way back to the starting point,the taxi driver may pick up additional passengers for his next trip to the airport.A map of passenger location has been created,represented as a square matrix.

The Matrix is filled with cells,and each cell will have an initial value as follows:

A value greater than or equal to zero represents a path.
A value equal to 1 represents a passenger.
A value equal to -1 represents an obstruction.
The rules of motion of taxi are as follows:

The Taxi driver starts at (0,0) and the railway station is at (n-1,n-1).Movement towards the railway station is right or down,through valid path cells.
After reaching (n-1,n-1) the taxi driver travels back to (0,0) by travelling left or up through valid path cells.
When passing through a path cell containing a passenger,the passenger is picked up.once the rider is picked up the cell becomes an empty path cell. 
If there is no valid path between (0,0) and (n-1,n-1),then no passenger can be picked.
The goal is to collect as many passengers as possible so that the driver can maximize his earnings.
 

Sample Input 0

4  

4 

0 0 0 1

1 0 0 0

0 0 0 0

0 0 0 0

Sample Output 0

2

Explanation 0

The driver can contain a maximum of 2 passengers by taking the following path (0,0) → (0,1) → (0,2) → (0,3) → (1,3) → (2,3) → (3,3) → (3,2) → (3,1) → (3,0) → (2,0) → (1,0)  → (0,0)

 

 

Sample Input 1

   3   

   3    

   0 1 -1 

   1 0 -1

   1 1 1

Sample Output 1

5

Explanation 1

The driver can contain a maximum of 5 passengers by taking the following path (0,0) → (0,1) → (1,1) → (2,1) → (2,2) → (2,1) → (2,0) → (1,0) → (0,0)

```
import java.util.*;
class Solution
{
  public static int cost (int grid[][], int row1, int col1, int row2, int col2)
  {
    if (row1 == row2 && col1 == col2)
    {
	    if (grid[row1][col1] == 1)
	        return 1;
	    return 0;
     }
    int ans = 0;
    if (grid[row1][col1] == 1)
        ans++;
    if (grid[row2][col2] == 1)
        ans++;
    return ans;
}

public static int solve (int n, int m, int grid[][], int dp[][][], int row1,int col1, int row2)
{
    int col2 = (row1 + col1) - (row2);
    if (row1 == n - 1 && col1 == m - 1 && row2 == n - 1 && col2 == m - 1) 
        return 0;
    if (row1 >= n || col1 >= m || row2 >= n || col2 >= m)
        return -1 * Integer.MAX_VALUE;
    if (dp[row1][col1][row2] != -1)
        return dp[row1][col1][row2];
    int ch1 = -1 * Integer.MAX_VALUE, ch2 = -1 * Integer.MAX_VALUE;
    int ch3 = -1 * Integer.MAX_VALUE, ch4 = -1 * Integer.MAX_VALUE;
    if (grid[row1][col1 + 1] != -1 && grid[row2 + 1][col2] != -1)
        ch1 = cost (grid, row1, col1 + 1, row2 + 1, col2) + solve (n, m, grid, dp,row1, col1 + 1,row2 + 1);
    if (grid[row1][col1 + 1] != -1 && grid[row2][col2 + 1] != -1)
        ch2 = cost (grid, row1, col1 + 1, row2, col2 + 1) + solve (n, m, grid, dp, row1, col1 + 1, row2);
    if (grid[row1 + 1][col1] != -1 && grid[row2][col2 + 1] != -1)
        ch3 = cost (grid, row1 + 1, col1, row2, col2 + 1) + solve (n, m, grid, dp, row1 + 1, col1, row2);
    if (grid[row1 + 1][col1] != -1 && grid[row2 + 1][col2] != -1)
        ch4 = cost (grid, row1 + 1, col1, row2 + 1, col2) + solve (n, m, grid, dp, row1 + 1, col1, row2 + 1);
    return dp[row1][col1][row2] =
    Math.max (ch1, Math.max (ch2, Math.max (ch3, ch4)));
}

public static void initializeDp (int dp[][][], int item)
{
    for (int i = 0; i < 5; i++)
    {
        for (int j = 0; j < 5; j++)
            for (int k = 0; k < 5; k++)
                dp[i][j][k] = item;
        }
    }
public static int collectMax (int n, int m, int grid[][])
{
    int ans = 0;
    int dp[][][] = new int[6][6][6];
    initializeDp (dp, -1);
    if (grid[n - 1][m - 1] == -1 || grid[0][0] == -1)
        ans = -1 * Integer.MAX_VALUE;
    if (grid[0][0] == 1)
        ans++;
        grid[0][0] = 0;
    if (grid[n - 1][m - 1] == 1)
        ans++;
        grid[n - 1][m - 1] = 0;

        ans += solve (n, m, grid, dp, 0, 0, 0);
        return Math.max (ans, 0);

}
public static void main (String[]args)
{
    Scanner sc = new Scanner (System.in);
    int n = sc.nextInt ();
    int m = sc.nextInt ();
    int arr[][] = new int[n + 1][m + 1];
    for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++)
    arr[i][j] = sc.nextInt ();
    System.out.println (collectMax (n, m, arr));
    }
}
```

Question 4
Problem Statement – Ratan is a crazy rich person. And he is blessed with luck, so he always made the best profit possible with the shares he bought. That means he bought a share at a low price and sold it at a high price to maximize his profit. Now you are an income tax officer and you need to calculate the profit he made with the given values of stock prices each day. You have to calculate only the maximum profit Ratan earned.

Note that:

Ratan never goes into loss.
 

Example 1

Price=[1,6,2]
Ratan buys it on the first day and sells it on the second. 
Example 2

Price=[9,8,6] 
The Price always went down, Ratan never bought it.

 

Input Format:

First line with an integer n, denoting the number days with the value of the stack
Next n days, telling the price of the stock on that very day.
 

Output Format:

Maximum profit done by Ratan in a single line.
 

Constraints:

Number of days <=10^8
 

Sample Input for Custom Testing

 

 STDIN              

———–       

7

1 

9 

2 

11

1 

9 

2




Sample Output

  10

 

 Explanation

The maximum profit possible is when Ratan buys it in 1 rupees and sells it in 11.
```
import java.util.*;
public class PrepInsta {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int price[] = new int[n];
    for (int i = 0; i < n; i++) {
      price[i] = sc.nextInt();
    }
    Vector < Integer > diff = new Vector < > ();
    for (int i = n - 2; i >= 0; i--) {
      diff.add(price[i + 1] - price[i]);
    }
    int ans = solve(diff);
    if (ans < 0) {
      System.out.println(0);
    } else {
      System.out.println(ans);
    }
  }
  private static int solve(Vector < Integer > v) {
    int n = v.size();
    if (n == 0) {
      return 0;
    }
    int mx = v.get(0);
    for (int i = 1; i < n; i++) {
      mx = Math.max(mx, v.get(i));
    }
    if (mx <= 0) {
      return 0;
    }
    int mxSum = 0, csum = 0;
    for (int i = 0; i < n; i++) {
      csum += v.get(i);
      if (csum < 0)
        csum = 0;
      mxSum = Math.max(csum, mxSum);
    }
    return mxSum;
  }
}
```

Question 5
Problem Statement – Codu is given a string and he thinks the letters that are repeated do have more power. He gathers only the repeating characters and keeps them as the most powerful to least powerful manner. Now it is your turn to write a code that will help Codu to do that.

Note that: only lowercase alphabets are accepted in input.

 

Input Format:

A string in a single line
 

Output Format:

A string made of only the repeated characters as sorted their frequency reducin, if the same the lower ascii value comes before.
 

Constraints:

Length of string<=10^5
 

Sample Input:

abcdefghaabca

 

Sample Output:

abc

```
import java.util.*;
public class StringReduction {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    TreeSet < Character > list = new TreeSet < Character > ();
    for (int i = 0; i + 1 < str.length(); i++) {
      String prefix = str.substring(0, i);
      String suffix = str.substring(i + 1, str.length());
      char ch = str.charAt(i);
      if (prefix.indexOf(ch) != -1 || suffix.indexOf(ch) != -1)
        list.add(ch);
    }
    if (str.substring(0, str.length() - 1).indexOf(str.charAt(str.length() - 1)) != -1)
      list.add(str.charAt(str.length() - 1));
    Iterator itr = list.iterator();
    while (itr.hasNext()) {
      System.out.print((Character) itr.next());
    }
  }
}
```


Question 6
Problem Statement – How will we represent a binary tree? We can use a bracket structure for all of the edges, like (Parentnode , Childnode). Now if we use a node in a child node more than once, the tree can not be valid. Same for the parent node, a node can not be taken more than twice in  a graph as a parent node.

Suppose we see this one graph

(P,Q)(P,R)(Q,T)(R,W)(U,V)(Q,S)(R,U)(U,Z)(S,I)(W,Y)

A tree with those edges may be illustrated in many ways.Here are two:

                   P                            P

                /    \                        /     \

              Q      R                   Q      R

            /   \     /    \               /   \    /  \

          S   T   U   W           S    T  U  W

            \        / \     \          /          / \      \

             I     V  Z    Y      I         Z  V    Y

The following is a recursive definition for the S-expression of a tree.

S-exp(node)=(node->val(S-exp(node->first_child))(S-exp(node->second_child))),if node

!NULL=””,node= =NULL

         Where first_child->val<second _child->val(first_child->val is lexicographically than second_child->val)

This tree can be represented in S-expression in multiple ways.The lexicographically smallest way of expressing it as follows:

P(Q(S(I))(T))(R(U(V)(Z))(W(Y))))

 

Translate the node-pair representation into its lexicographically smallest S-expression or report any errors that do not conform to the definition of the binary tree.

The List of errors with their codes is as follows: 

 

Error                               Reason

Code Stopped1                More than 2 children

Code Stopped2                Duplicate Edges

Code Stopped3                Cycle Present(node is direct descendant of more than one node)

Code Stopped4                Multiple Roots

Code Stopped5                Any other error

 

Functional Description

 

Complete the function sExpression in the editor below.

The function must return either the lexicographically lowest S-expression or the lexicographically lowest error code as a string.
 

sExpression has the following parameter(s):

Nodes:a string of space-separated parenthetical elements,each of which contains the name of two nodes connected by a comma.
 

Constraints:

All node names are single characters in the range ascii[A-Z].
The maximum node count is 26.
There is no specific order to the input (parent,child) pairs.
 

>Input Format for Custom Testing

>Sample Case 0

Sample Input 0

(B,D) (D,E) (A,B) (C,F) (E,G) (A,C)

Sample output 0

(A(B(D(E(G))))(C(F)))

Explanation 0

A representation of tree is as follows:

 

             A

           /    \

         B      C

         /         \

       D           F

      /

     E

    /

  G

>Sample Case 1

Input:

(C,E)(D,F)(A,B)(A,C)(B,K)

Output:

A(B(K))(C(E)))D(F))