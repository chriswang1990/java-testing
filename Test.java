package testing;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Test {
  public void original() {
    Integer a = 5;
    change(a);
  }

  private void change(Integer a) {
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
      //test how to convert a Integer char to int, cast is not a good option;
      PriorityQueue<Integer> pq = new PriorityQueue<>((Integer a, Integer b) -> b - a);

      pq.offer(5);
      pq.offer(4);
      pq.offer(3);
      pq.offer(2);
      pq.offer(1);
      pq.offer(6);
      while (!pq.isEmpty()) {
        System.out.println(pq.poll());
      }
      int five = 5;
      System.out.println(five++);
      System.out.println(++five);
      System.out.println(five--);
      System.out.println(--five);
      System.out.println("string contains string: " + "121314151618192012345689101171722232524".contains("12"));

      String i = "abc";
      Object o = i;
      System.out.println(i.equals(o));

    }
  }
}
