package leetcode;

public class StringInString {

    public static int findStr (String str1, String str2) {
        if (str1.length() == 0) {
            return 1;
        }
        int ans = 0;
        int j = 0;
        while ( j < str2.length() - str1.length() + 1) {
            if (str1.charAt(0) == str2.charAt(j)) {
                ans += findStr(str1.substring(1), str2.substring(j + 1));
            }
            j++;
        }
        return ans;
    }

    public static int findStr2 (String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][]dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        System.out.println(findStr2("eal", "eaeal"));
        System.out.println(findStr("eal", "eaeal"));
    }
}