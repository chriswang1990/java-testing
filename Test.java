package testing;

import java.util.ArrayList;

public class Test {
    public void original() {
        Integer a = 5;
        change(a);
        System.out.println(a);
    }

    private void change(Integer a) {
        System.out.println(a);
        a += 1;   //Integer is immutable
    }

    public static void main(String[] args) {
        Test a = new Test();
        a.original();

//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        for (int i : list) {
//            System.out.println(i);
//        }
    }

    public static class Permutations {
        public ArrayList<ArrayList<Integer>> permute(int[] num) {
            ArrayList<ArrayList<Integer>> rst = new ArrayList<>();
            if (num == null || num.length == 0) {
                return rst;
            }

            ArrayList<Integer> list = new ArrayList<>();
            helper(rst, list, num);
            return rst;
        }

        public void helper(ArrayList<ArrayList<Integer>> rst, ArrayList<Integer> list, int[] num) {
            if (list.size() == num.length) {
                rst.add(new ArrayList<>(list));
                return;
            }

            for (int i = 0; i < num.length; i++) {
                if (list.contains(num[i])) {
                    continue;
                }
                list.add(num[i]);
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
}
