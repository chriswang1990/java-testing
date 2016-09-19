package testing.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/*
Given an integer array, adjust each integers so that the difference of every adjacent integers are
not greater than a given number target.

If the array before adjustment is A, the array after adjustment is B, you should minimize the sum
of |A[i]-B[i]|

Notice:
You can assume each number in the array is a positive integer and not greater than 100.
 */

public class MinimumAdjustmentCost {
  public static int MinAdjustmentCost1(ArrayList<Integer> A, int target) {
    if (A == null || A.size() == 0) {
      return 0;
    }
    return helper1(A, new ArrayList<>(A), target, 0);
  }

  public static int helper1(ArrayList<Integer> A, ArrayList<Integer> B, int target, int index) {
    int len = A.size();
    if (index >= len) {
      return 0;
    }
    int min = Integer.MAX_VALUE;
    for (int i = 1; i <= 4; i++) {
      if (index != 0 && Math.abs(B.get(index - 1) - i) > target) {
        continue;
      }
      B.set(index, i);
      int dif = Math.abs(i - A.get(index));
      dif += helper1(A, B, target, index + 1);
      min = Math.min(min, dif);
      //backtracking
      B.set(index, A.get(index));
    }
    return min;
  }

  public static int MinAdjustmentCost2(ArrayList<Integer> A, int target) {
    if (A == null || A.size() == 0) {
      return 0;
    }
    int[][] f = new int[A.size()][101];
    for (int i = 0; i < A.size(); i++) {
      for (int j = 0; j < 101; j++) {
        f[i][j] = Integer.MAX_VALUE;
      }
    }
    return helper2(A, new ArrayList<>(A), target, 0, f);
  }

  public static int helper2(ArrayList<Integer> A, ArrayList<Integer> B, int target, int index,
                            int[][] f) {
    int len = A.size();
    if (index >= len) {
      return 0;
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i <= 100; i++) {
      if (index != 0 && Math.abs(B.get(index - 1) - i) > target) {
        continue;
      }
      B.set(index, i);
      if (f[index][i] != Integer.MAX_VALUE) {
        min = Math.min(f[index][i], min);
        continue;
      }
      int dif = Math.abs(i - A.get(index));
      dif += helper2(A, B, target, index + 1, f);
      min = Math.min(min, dif);
      f[index][i] = dif;
      //backtracking
      B.set(index, A.get(index));
    }
    return min;
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(12,3,7,4,5,13,2,8,4,7,6,5,7));
    System.out.println(MinAdjustmentCost2(list, 2));
  }
}
