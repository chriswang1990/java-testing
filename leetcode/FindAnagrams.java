package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 1990c on 12/18/2016.
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<Integer>();
        p = p.toLowerCase();
        s = s.toLowerCase();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, 0);
        }
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, map.get(c) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.get(c) - 1);
            if (i - p.length() >= 0 ) {
                char prev = s.charAt(i - p.length());
                map.put(prev, map.get(prev) + 1);
            }
            boolean valid = true;
            for (char k = 'a'; k <= 'z'; k++) {
                if (map.get(k) != 0) {
                    valid = false;
                }
            }
            if (valid) {
                ans.add(i - p.length() + 1);
            }
        }
        return ans;
    }
}
