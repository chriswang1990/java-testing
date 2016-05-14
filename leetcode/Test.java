package testing.leetcode;

import java.util.ArrayList;

/**
 * Created by 1990c on 3/4/2016.
 */
public class Test {
  public void original(){
    int a = 5;
    change(a);
    System.out.println(a);
  }

  private void change(int a) {
    System.out.println(a);
    a = 6;
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    for (int i : list) {
      System.out.println(i);
    }
  }

  public static class Permutations {
      public ArrayList<ArrayList<Integer>> permute(int[] num) {
          ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
          if (num == null || num.length == 0) {
              return rst;
          }

          ArrayList<Integer> list = new ArrayList<Integer>();
          helper(rst, list, num);
          return rst;
      }

      public void helper(ArrayList<ArrayList<Integer>> rst, ArrayList<Integer> list, int[] num){
          if(list.size() == num.length) {
              rst.add(new ArrayList<Integer>(list));
              return;
          }

          for(int i = 0; i<num.length; i++){
              if(list.contains(num[i])){
                  continue;
              }
              list.add(num[i]);
              helper(rst, list, num);
              list.remove(list.size() - 1);
          }

      }

      public static void main(String[] args) {
          int[] num = {1,2,3};
          Permutations p = new Permutations();
          System.out.println(p.permute(num));
      }
  }
}
