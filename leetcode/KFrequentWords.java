package leetcode;
import java.util.*;

public class KFrequentWords {
  public static String[] topKFrequentWords(String[] words, int k) {
    // Write your code here
    HashMap<String, Integer> map= new HashMap<>();
    for (String s : words) {
      if (map.containsKey(s)) {
        map.put(s, map.get(s) + 1);
      } else {
        map.put(s, 1);
      }
    }
    for (String s : words) {
      map.get(s);
    }
    ArrayList<Map.Entry<String, Integer>> listForSorting = new ArrayList<>(map.entrySet());
    Collections.sort(listForSorting, (a, b) -> {
        if (a.getValue().equals(b.getValue())) {
          return a.getKey().compareToIgnoreCase(b.getKey());
        } else {
          return (a.getValue() - b.getValue());
        }
    });
    String[] ans = new String[k];
    for (int i = 0; i < k; i++) {
      ans[i] = listForSorting.get(i).getKey();
    }
    return ans;
  }

  public static void main(String[] args) {
    String[] list = {
      "yes", "lint", "code", "yes", "code", "baby", "you", "baby", "chrome", "safari", "lint", "code", "body", "lint",
        "code"};
    System.out.println(Arrays.toString(KFrequentWords.topKFrequentWords(list, 4)));
  }
}
