# 874. Walking Robot Simulation
A robot on an infinite XY-plane starts at point (0, 0) facing north. The robot can receive a sequence of these three possible types of commands:

-2: Turn left 90 degrees.
-1: Turn right 90 degrees.
1 <= k <= 9: Move forward k units, one unit at a time.
Some of the grid squares are obstacles. The ith obstacle is at grid point obstacles[i] = (xi, yi). If the robot runs into an obstacle, then it will instead stay in its current location and move on to the next command.

Return the maximum Euclidean distance that the robot ever gets from the origin squared (i.e. if the distance is 5, return 25).

Note:

North means +Y direction.
East means +X direction.
South means -Y direction.
West means -X direction.
There can be obstacle in [0,0].
 
```
Example 1:

Input: commands = [4,-1,3], obstacles = []
Output: 25
Explanation: The robot starts at (0, 0):
1. Move north 4 units to (0, 4).
2. Turn right.
3. Move east 3 units to (3, 4).
The furthest point the robot ever gets from the origin is (3, 4), which squared is 32 + 42 = 25 units away.
```
```
Example 2:

Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
Output: 65
Explanation: The robot starts at (0, 0):
1. Move north 4 units to (0, 4).
2. Turn right.
3. Move east 1 unit and get blocked by the obstacle at (2, 4), robot is at (1, 4).
4. Turn left.
5. Move north 4 units to (1, 8).
The furthest point the robot ever gets from the origin is (1, 8), which squared is 12 + 82 = 65 units away.
```
```
Example 3:

Input: commands = [6,-1,-1,6], obstacles = []
Output: 36
Explanation: The robot starts at (0, 0):
1. Move north 6 units to (0, 6).
2. Turn right.
3. Turn right.
4. Move south 6 units to (0, 0).
The furthest point the robot ever gets from the origin is (0, 6), which squared is 62 = 36 units away.
```

# Code Solution
Direction representation    [0,1] +y
Direction representation    [0,-1] -y
Direction representation    [1,0] +x
Direction representation    [-1,0] -x
-2 Left 90 deg
-1 right 90 deg

after each movt calc distance and find max
we stop one stop befor obstacle
Direction order={[0,1],[1,0],[0,-1],[1,0]} cw N,E,S,W MOVT 
keep track d(index)=(d+1)%4; forward;
keep track d(index)=(d-1)%4; backward;


```
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0; // Initial position
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // N, E, S, W
        int d = 0; // Initial direction index (facing North)
        int res = 0;

        // Convert obstacle array to a set of strings for quick lookup
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        // Execute commands
        for (int command : commands) {
            if (command == -1) {
                d = (d + 1) % 4; // Turn right
            } else if (command == -2) {
                d = (d + 3) % 4; // Turn left (same as turning right 3 times)
            } else {
                int dx = directions[d][0];
                int dy = directions[d][1];
                for (int i = 0; i < command; i++) {
                    int nx = x + dx;
                    int ny = y + dy;
                    if (obstacleSet.contains(nx + "," + ny)) {
                        break; // Stop if there's an obstacle
                    }
                    x = nx;
                    y = ny;
                    res = Math.max(res, x * x + y * y);
                }
            }
        }

        return res;
    }
}
```
