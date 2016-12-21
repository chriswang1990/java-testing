package testing.leetcode;

import java.util.ArrayList;

public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<>();
        if (num == null || num.length == 0) {
            return rst;
        }

        ArrayList<Integer> list = new ArrayList<>();
        helper(rst, list, num);
        return rst;
    }

    private void helper(ArrayList<ArrayList<Integer>> rst, ArrayList<Integer> list, int[] num) {
        if (list.size() == num.length) {
            rst.add(new ArrayList<>(list));
            return;
        }

        for (int i : num) {
            if (list.contains(i)) {
                continue;
            }
            list.add(i);
            helper(rst, list, num);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3};
        Permutations p = new Permutations();
        System.out.println(p.permute(num));
    }

}
