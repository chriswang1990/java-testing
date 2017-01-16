package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/*
Given a 2D array which have the positions for coffee machines,
return a 2D array with the distance to the nearest coffee machine in each cell
*/

public class CoffeeMachine {

    public static int[][] coffeeMachine(int[][] plan) {
        ArrayList<int[]> cellList = new ArrayList<>();
        //find the coffee machine location and initialize all other cell with -1
        for (int i = 0; i < plan.length; i++) {
            for (int j = 0; j < plan[0].length; j++) {
                if (plan[i][j] == 1) {
                    plan[i][j] = 0;
                    cellList.add(new int[]{i, j});
                } else {
                    plan[i][j] = -1;
                }
            }
        }
        //BFS starts here, use ArrayList to simulate a queue
        int i = 0;
        while (i < cellList.size()) {
            int[] cur = cellList.get(i);
            i++;
            int[][] neighbours = new int[][] {
                    {0,1},
                    {0, -1},
                    {1, 0},
                    {-1, 0}
            };
            for (int[] neighbour : neighbours) {
                int x1 = cur[0] + neighbour[0];
                int x2 = cur[1] + neighbour[1];
                if (x1 >= 0 && x1 < plan.length && x2 >= 0 && x2 < plan[0].length && plan[x1][x2] == -1) {
                    plan[x1][x2] = plan[cur[0]][cur[1]] + 1;
                    cellList.add(new int[] {x1, x2});
                }
            }
        }
        return plan;
    }

    //just some test code for your convenience
    public static void main(String[] args) {
        int[][] plan = new int[][] {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        System.out.println(Arrays.deepToString(coffeeMachine(plan)));
    }
}
