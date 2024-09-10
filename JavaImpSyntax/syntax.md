# Java Collections and Utilities

This guide provides a quick reference for commonly used Java collections, string manipulations, and utility methods. It covers basic operations for `HashMap`, `HashSet`, `List`, `String`, and other utilities.

## Collections Overview

### Common Methods for Collections

All Java collections (`HashMap`, `HashSet`, `List`) support the following methods:

- `add()`
- `addAll()`
- `remove()`
- `size()`
- `clear()`

## HashSet

A `HashSet` is a collection that contains no duplicate elements.
###### For easy access of elements in array convert to hashset.
### Example: HashSet Usage

```java
HashSet<Character> hs = new HashSet<>();
Collections.addAll(hs, 'a', 'e', 'i', 'o', 'u');

boolean contains = hs.contains('a'); // Check if 'a' is in the set

// For quick Lookup
 Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

         if (obstacleSet.contains(nx + "," + ny)) {
                        break; // Stop if there's an obstacle
                    }
```

## HashMap
A HashMap is a collection that stores key-value pairs, with unique keys.

**Example: HashMap Usage**
``` 
HashMap<Character, Integer> hm = new HashMap<>();
for (char c : "example".toCharArray()) {
    hm.put(c, hm.getOrDefault(c, 0) + 1); // Update character count
}

for (char key : hm.keySet()) {
    int value = hm.get(key); // Get the value associated with the key
}

boolean hasKey = hm.containsKey('a'); // Check if key 'a' exists

for checking if 2 equal
return h1.equals(h2);
```

**Example: HashMap with List as Value**
```
HashMap<String, List<String>> hm = new HashMap<>();
String sorted = "abc";

hm.putIfAbsent(sorted, new ArrayList<>());
hm.get(sorted).add("string");

hm.computeIfAbsent(sorted, k -> new HashSet<>()).add("value");
```

# List

A List is an ordered collection, allowing duplicate elements.

Example: List Operations

```
List<Character> vow = Arrays.asList('a', 'e', 'i', 'o', 'u');
vow.clear(); // Clear the list

Collections.reverse(vow); // Reverse the list

Character element = vow.get(0); // Get element at index 0

// Modify element at index 1
vow.set(1, 'z');

```
# Array to List
```
Character[] vowelsArray = {'a', 'e', 'i', 'o', 'u'};
List<Character> vowelsList = Arrays.asList(vowelsArray);

```

# String Manipulations
String Operations
```
String result = (str1 + str2).equals(str2 + str1); // String equality check

String substring = str1.substring(0, gcdLength); // Get substring from index 0 to gcdLength

int number = Integer.valueOf(str); // Convert string to integer
String str = String.valueOf(count); // Convert integer to string

char[] chars = s1.toCharArray(); // Convert string to char array
String sub = s1.substring(i, j); // Get substring from i to j-1
boolean equals = s1.equals(s2); // Compare strings for equality

String reversed = new StringBuilder(s).reverse().toString(); // Reverse a string

txt.toUpperCase()
txt.toLowerCase()

```

# StringBuilder Usage
```StringBuilder sb = new StringBuilder(s);

// Clear the StringBuilder
sb.setLength(0);

for getting Integer Value directly
int res=sb.charAt(i)-'0';

// Split string by whitespace
String[] parts = s.split("\\s+");

// Convert to uppercase
String upper = s.toUpperCase();

//Trim white spaces
String s=s.nextLine().trim();
```

# Characters
Character Operations
``` 
boolean isLetterOrDigit = Character.isLetterOrDigit(s.charAt(l)); // Check if character is a letter or digit

char upper = Character.toUpperCase(ch); // Convert character to uppercase
```

# Type Casting
```
char c = (char)(a + '0'); // Cast integer to char
```

# Stack
A Stack is a last-in, first-out (LIFO) data structure.

Example: Stack Usage
```
Stack<int[]> stack = new Stack<>(); // Stack of int[] pairs

// Push a pair onto the stack
stack.push(new int[]{temp, index});

```

# Array Utilities
Array Operations    
```
char[] ch = s.toCharArray();
Arrays.sort(ch); // Sort the array

String arrayString = Arrays.toString(ch); // Convert array to string representation

int[] dp = new int[n];
Arrays.fill(dp, 1); // Fill array with 1
```

