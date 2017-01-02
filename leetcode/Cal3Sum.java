package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by 1990c on 9/22/2016.
 */
public class Cal3Sum {
  /**
   * @param numbers : Give an array numbers of n integer
   * @return : Find all unique triplets in the array which gives the sum of zero.
   */
  public static ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
    // write your code here
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    if (numbers == null || numbers.length < 3) {
      return null;
    }
    Arrays.sort(numbers);
    int len = numbers.length;
    HashSet<String> set = new HashSet<>();
    for (int i = 0; i < len - 2; i++) {
      int a = numbers[i];
      int j = i + 1;
      int k = len - 1;
      while (j < k) {
        int b = numbers[j];
        int c = numbers[k];
        int sum = b + c;
        if (sum == -a) {
          String s = "" + a + "a" + b + "a" + c;
          if (!set.contains(s)) {
            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(a, b, c));
            set.add(s);
            ans.add(list);
          }
          j++;
        } else if (sum < -a) {
          j++;
        } else {
          k--;
        }
      }
    }
    System.out.println(set);
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(threeSum(new int[]{1,0,-1,-1,-1,-1,0,1,1,1}));
  }
}
