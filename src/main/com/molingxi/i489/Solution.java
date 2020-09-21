package main.com.molingxi.i489;

/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

/**
 * Given a robot cleaner in a room modeled as a grid.
 *
 * Each cell in the grid can be empty or blocked.
 *
 * The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made is 90 degrees.
 *
 * When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.
 *
 * Design an algorithm to clean the entire room using only the 4 given APIs shown below.
 *
 * interface Robot {
 *   // returns true if next cell is open and robot moves into the cell.
 *   // returns false if next cell is obstacle and robot stays on the current cell.
 *   boolean move();
 *
 *   // Robot will stay on the same cell after calling turnLeft/turnRight.
 *   // Each turn will be 90 degrees.
 *   void turnLeft();
 *   void turnRight();
 *
 *   // Clean the current cell.
 *   void clean();
 * }
 *
 * Example:
 *
 * Input:
 * room = [
 *   [1,1,1,1,1,0,1,1],
 *   [1,1,1,1,1,0,1,1],
 *   [1,0,1,1,1,1,1,1],
 *   [0,0,0,1,0,0,0,0],
 *   [1,1,1,1,1,1,1,1]
 * ],
 * row = 1,
 * col = 3
 *
 * Explanation:
 * All grids in the room are marked by either 0 or 1.
 * 0 means the cell is blocked, while 1 means the cell is accessible.
 * The robot initially starts at the position of row=1, col=3.
 * From the top left corner, its position is one row below and three columns right.
 * Notes:
 *
 * The input is only given to initialize the room and the robot's position internally. You must solve this problem "blindfolded". In other words, you must control the robot using only the mentioned 4 APIs, without knowing the room layout and the initial robot's position.
 * The robot's initial position will always be in an accessible cell.
 * The initial direction of the robot will be facing up.
 * All accessible cells are connected, which means the all cells marked as 1 will be accessible by the robot.
 * Assume all four edges of the grid are all surrounded by wall.
 */
class Solution {




    public void cleanRoom(Robot robot) {

    }



    interface Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current cell.
        public boolean move();

        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        public void turnLeft();
        public void turnRight();

        // Clean the current cell.
        public void clean();
      }

    /**
     * // This is the robot's control interface.
     * // You should not implement it, or speculate about its implementation
     * interface Robot {
     *     // Returns true if the cell in front is open and robot moves into the cell.
     *     // Returns false if the cell in front is blocked and robot stays in the current cell.
     *     public boolean move();
     *
     *     // Robot will stay in the same cell after calling turnLeft/turnRight.
     *     // Each turn will be 90 degrees.
     *     public void turnLeft();
     *     public void turnRight();
     *
     *     // Clean the current cell.
     *     public void clean();
     * }
     */
}
/*



class Solution {

    int [][] steps = new int[][] {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    final static int WALL = 1000;

    final static int XWEIGHT = 10000;

    public void cleanRoom(Robot robot) {


        int x, y;
        x = 0;
        y = 0;
        Map<Integer, Integer> trace = new HashMap<>();


        int direction = 0;
        trace.put(0, 1);
        robot.clean();


        while (trace.get(0) < 5) {


            if (robot.move()) {
                robot.clean();

                x += steps[direction][0];
                y += steps[direction][1];

                trace.put(x * XWEIGHT + y,
                         trace.getOrDefault(x * XWEIGHT + y, 0) + 1);

            } else {
                trace.put((x + steps[direction][0]) * XWEIGHT + y + steps[direction][1], WALL );
                direction = (direction + 1) % 4;
                robot.moveLeft();
            }

            int newDir = -1;
            int currentValue = trace.get(x * XWEIGHT + y);

            for (int i = 3;i < 6;i ++){
                int tNewDir = (direction + i) % 4;

                int key = (x + steps[tNewDir][0]) * XWEIGHT + y + steps[tNewDir][1];

                if (trace.getOrDefault(key, 0) < currentValue) {
                    currentValue = trace.getOrDefault(key, 0);
                    newDir = tNewDir;
                }
            }

            if (newDir < 0) {
                trace.put(x * XWEIGHT + y, trace.get(x * XWIGHT + y) + 1);
            } else {
                while (direction != newDir) {
                    robot.moveLeft();
                    dirction = (direction + 1 ) % 4;
                }
            }
        }

        return;
    }
}




 */