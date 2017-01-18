package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cwang on 1/17/2017.
 */
public class NumberOfIslandsII {
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Write your code here
        int[] parentMap = new int[n * m];
        for (int i = 0; i < n * m; i++) {
            parentMap[i] = -1;
        }
        List<Integer> ans = new ArrayList<Integer>();
        if (operators == null || operators.length == 0) {
            return ans;
        }
        int count = 0;
        int[][] ds = new int[][]{
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}};
        for (int i = 0; i < operators.length; i++) {
            Point point = operators[i];
            int pointInd = point.x * m + point.y;
            parentMap[pointInd] = pointInd;
            count++;
            for (int j = 0; j < 4; j++) {
                int[] d = ds[j];
                int curX = point.x + d[0];
                int curY = point.y + d[1];
                int curInd = curX * m + curY;
                if (curX >= 0 && curX < n && curY >= 0 && curY < m
                        && parentMap[curInd] != -1) {
                    if (union(parentMap, curInd, pointInd)) {
                        count--;
                    }
                }
            }
            for (int ii = 0; ii < n; ii++) {
                for (int jj = 0; jj < m; jj++) {
                    System.out.print(String.format("%4d", parentMap[ii * n + jj]));
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
            ans.add(count);
        }
        return ans;
    }

    public int find(int[] parentMap, int n) {
        int parent = parentMap[n];
        while (parentMap[parent] != parent) {
            parent = parentMap[parent];
        }
        while (n != parentMap[n]) {
            int temp = parentMap[n];
            parentMap[n] = parent;
            n = temp;
        }
        return parent;
    }

    public boolean union(int[] parentMap, int a, int b) {
        int parentA = find(parentMap, a);
        int parentB = find(parentMap, b);
        if (parentA != parentB) {
            parentMap[parentB] = parentA;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        NumberOfIslandsII ni = new NumberOfIslandsII();
        Point[] operators = {new Point(1, 1),new Point(0, 9), new Point(5, 4),
                new Point(0, 12), new Point(6, 9),
                new Point(6, 5), new Point(0, 4)};
        System.out.println(Arrays.toString(ni.numIslands2(8, 14, operators).toArray()));
    }
}

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}