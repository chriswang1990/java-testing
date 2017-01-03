package leetcode;

import java.util.Scanner;

/**
 * Created by 1990c on 12/16/2016.
 */
public class AlgorithmicCrush {

  public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    int M = in.nextInt();
    long max = Long.MIN_VALUE;
    long[] array = new long[N];
    for (int i = 0; i < M; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      int k = in.nextInt();
      for (int j = a - 1; j < b; j++) {
        array[j] += k;
        if (array[j] > max) {
          max = array[j];
        }
      }
    }
    System.out.println(max);
    in.close();
  }
}
