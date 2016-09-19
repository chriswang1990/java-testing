package testing.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

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
        for (int i = 0; i <= 4; i++) {
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



    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 10, 2, 3));
        System.out.println(MinAdjustmentCost1(list, 1));
    }
}
