package testing.leetcode;
import java.util.*;

/**
 * Created by 1990c on 3/30/2016.
 */
public class KFrequentWords {
  public String[] topKFrequentWords(String[] words, int k) {
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
    Collections.sort(listForSorting, new Comparator<Map.Entry<String, Integer>>() {
      @Override
      public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
        if (a.getValue().equals(b.getValue())) {
          return a.getKey().compareToIgnoreCase(b.getKey());
        } else {
          return (a.getValue() - b.getValue());
        }
      }
    });
    String[] ans = new String[k];
    for (int i = 0; i < k; i++) {
      ans[i] = listForSorting.get(i).getKey();
    }
    return ans;
  }
}
