package leetcode;

/**
 The count-and-say sequence is the sequence of integers beginning as follows:

 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.

 Given an integer n, generate the nth sequence.
 */
public class CountAndSay {
    public static String countAndSay(int n) {
        // Write your code here
        String ans = "1";
        for (int i = 1; i < n; i++) {
            String cur = "";
            int j = 0;
            int len = ans.length();
            while (j < len) {
                char c = ans.charAt(j);
                int count = 1;
                j++;
                while (j < len && ans.charAt(j) == c) {
                    count++;
                    j++;
                }
                cur = cur + count + c;
            }
            ans = cur;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }
}
