package testing;

import java.util.Scanner;

public class Testing {

    public static int maxSum (int[] a, int n, int t) {
        int maxSum = 0;
        int sum = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (sum == t) {
                return t;
            } else if (sum < t) {
                maxSum = Math.max(sum, maxSum);
            } else {
                while (start <= i) {
                    sum -= a[start];
                    start++;
                    if (sum == t) {
                        return t;
                    } else if (sum < t) {
                        maxSum = Math.max(sum, maxSum);
                        break;
                    }
                }
            }
        }
        return maxSum;
    }

    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int ans = maxSum(a, n, t);
        System.out.println(ans);

    }

}