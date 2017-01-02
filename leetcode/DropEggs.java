package leetcode;

/**
 There is a building of n floors. If an egg drops from the k th floor or above, it will break. If it's dropped from any
 floor below, it will not break.
 You're given m eggs, Find k while minimize the number of drops for the worst case. Return the number of drops in the
 worst case.

 Example
 Given m = 2, n = 100 return 14
 Given m = 2, n = 36 return 8
 */
public class DropEggs {
  /**
   * @param m the number of eggs
   * @param n the umber of floors
   * @return the number of drops in the worst case
   */
  public static int dropEggs(int m, int n) {
    // Write your code here
    if (m < 1 || n < 0) {
      return -1;
    }

    int[][] dp = new int[m + 1][n + 1];

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (i == 1) {
          dp[i][j] = j;
          continue;
        }
        int min = n;
        for (int k = 1; k <= j; k++) {
          min = Math.min(min, Math.max(dp[i - 1][k - 1], dp[i][j - k]) + 1);
        }
        dp[i][j] = min;
      }
    }

    return dp[m][n];
  }

  public static void main(String[] args) {
    System.out.println(DropEggs.dropEggs(2, 100));
  }
}
