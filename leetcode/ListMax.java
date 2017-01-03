package leetcode;

import java.util.*;
import java.lang.Math;

public class ListMax {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] res = new long[n];
        long max = Long.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < m; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            int val = in.nextInt();
            res[start - 1] += val;
            if (end < n) {
                res[end] -= val;
            }
        }
        for (int i = 0; i < n; i++) {
            sum += res[i];
            max = Math.max(sum, max);
        }
        System.out.println(max);
    }
}