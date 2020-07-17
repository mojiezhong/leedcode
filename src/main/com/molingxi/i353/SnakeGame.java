package main.com.molingxi.i353;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class SnakeGame {

    public static void main(String[] args) {
        SnakeGame game = new SnakeGame(
                2, 3,
                new int[][]{{1, 2}, {0, 1}}
        );


        game.move("R");
        game.move("D");
        game.move("R");
        game.move("U");
        game.move("L");
        game.move("U");
    }


    int width, height;


    HashSet<Long> occupied = new HashSet<>();

    LinkedList<int[]> body = new LinkedList<>();

    int score;

    Map<String, int[]> move;


    int[][] food;


    /**
     * Initialize your data structure here.
     *
     * @param width  - screen width
     * @param height - screen height
     * @param food   - A list of food positions
     *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
     */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;

        body.add(new int[]{0, 0});
        score = 0;

        occupied.add(0L);
        move = new HashMap<>();

        move.put("U", new int[]{-1, 0});
        move.put("L", new int[]{0, -1});
        move.put("R", new int[]{0, 1});
        move.put("D", new int[]{1, 0});
    }

    /**
     * Moves the snake.
     *
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over.
     * Game over when snake crosses the screen boundary or bites its body.
     */
    public int move(String direction) {
        int[] dir = move.get(direction.toUpperCase());
        int[] cur = body.peekLast();
        int[] newHead = new int[]{cur[0] + dir[0], cur[1] + dir[1]};

        long hit = ((long) newHead[0] << 32) + newHead[1];
        int[] tail = body.peekFirst();


        if (score < food.length && food[score][0] == newHead[0] && food[score][1] == newHead[1]) {
            score++;
        } else {
            body.removeFirst();
            occupied.remove(
                    ((long) tail[0]) << 32 + tail[1]
            );

        }

        if (newHead[0] < 0 || newHead[0] >= height || newHead[1] < 0 || newHead[1] >= width ||
                occupied.contains(hit)) {
            return -1;
        }
        occupied.add(hit);
        body.addLast(newHead);

        return score;

    }
}


/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
