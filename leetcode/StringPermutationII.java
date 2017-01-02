package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 Given a string, find all permutations of it without duplicates.
 Example

 Given "abb", return ["abb", "bab", "bba"].
 Given "aabb", return ["aabb", "abab", "baba", "bbaa", "abba", "baab"].
 */
public class StringPermutationII {
  /**
   * @param str a string
   * @return all permutations
   */
  public static List<String> stringPermutation2(String str) {
    // Write your code here
    List<String> ans = new ArrayList<String>();
    if (str == null || str.length() == 0) {
      return ans;
    }
    char[] array = str.toCharArray();
    Arrays.sort(array);
    str = new String(array);
    String cur = "";
    boolean[] visited = new boolean[str.length()];
    for (int i = 0; i < str.length(); i++) {
      visited[i] = false;
    }
    helper(str, cur, ans, visited);
    return ans;
  }

  public static void helper(String str, String cur, List<String> ans, boolean[] visited) {
    int len = str.length();
    if (cur.length() == len) {
      ans.add(cur);
      return;
    }
    for (int i = 0; i < len; i++) {
      char c = str.charAt(i);
      if (visited[i] || (i != 0 && str.charAt(i - 1) == c && !visited[i - 1])) {
        continue;
      }
      visited[i] = true;
      cur += c;
      helper(str, cur, ans, visited);
      cur = cur.substring(0, cur.length() - 1);
      visited[i] = false;
    }
  }

  public static void main(String[] args) {
    System.out.println(stringPermutation2("abb"));
  }
}
