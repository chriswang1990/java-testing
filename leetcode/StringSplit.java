package testing.leetcode;

import java.util.Arrays;

/**
 * Created by 1990c on 12/17/2016.
 */
public class StringSplit {
  public static void main(String[] args) {
    String input = "ab cde  _)(&*^&__& fg --  hi///jklm - n";
    String[] array = input.split("[\\W_]+");
    System.out.println(Arrays.toString(array));
  }
}
