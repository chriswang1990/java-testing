package testing.interview;

/**
 * Created by 1990c on 2/17/2017.
 */
public class DiceGame {

    public static long diceGame(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= 6; j++) {
                if (i - j >= 0) {
                    dp[i] += dp[i - j];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(diceGame(610));
    }
}
