package testing.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by 1990c on 5/14/2016.
 */
public class WordLadderII {

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        if (start == null || end == null || dict == null) {
            return res;
        }
        if (start.length() == 0 || end.length() == 0 || dict.size() == 0) {
            return res;
        }
        if (start.equals(end)) {
            list.add(start);
            res.add(list);
            return res;
        }
        int level = 1;
        int targetLevel = -1;
        HashMap<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        map.put(start, level);
        queue.offer(start);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            level = map.get(word);
            if (getNextLevel(word, end, level + 1, map, queue, dict)) {
                targetLevel = level;
                System.out.println(targetLevel);
                break;
            }
        }
        if (targetLevel == -1) {
            return res;
        }
        list.add(end);
        lHelper(end, start, targetLevel, list, res, map);
        return res;
    }

    private boolean getNextLevel (String word, String end, int level, HashMap<String, Integer> map, Queue<String> queue, Set<String> dict) {
        boolean found = false;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String newWord = buildWord(word, c, i);
                if (newWord.equals(end)) {
                    found = true;
                    break;
                }
                if (!dict.contains(newWord)) {
                    continue;
                }
                if (!map.containsKey(newWord)) {
                    map.put(newWord, level);
                    queue.offer(newWord);
                }
            }
        }
        return found;
    }

    private void lHelper (String word, String start, int level, ArrayList<String> list, List<List<String>> res, HashMap<String, Integer> map) {
        int len = word.length();
        for (int i = 0; i < len; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String newWord = buildWord(word, c, i);
                if (newWord.equals(start)) {
                    list.add(newWord);
                    res.add(reverse(list));
                    list.remove(list.size() - 1);
                    return;
                }
                if (!map.containsKey(newWord)) {
                    continue;
                }
                if (map.get(newWord) != level) {
                    continue;
                }
                list.add(newWord);
                lHelper(newWord, start, level - 1, list, res, map);
                list.remove(list.size() - 1);
            }
        }
    }

    private String buildWord (String word, char c, int i) {
        StringBuilder builder = new StringBuilder(word);
        builder.setCharAt(i, c);
        return builder.toString();
    }

    private ArrayList<String> reverse (ArrayList<String> list) {
        ArrayList<String> rev = new ArrayList<>();
        int len = list.size();
        for (int i = len - 1; i >= 0; i--) {
            rev.add(list.get(i));
        }
        return rev;
    }

    public static void main(String[] args) {
        WordLadderII wordLadderII = new WordLadderII();
        Set<String> dict = new HashSet<>();
        dict.add("a");
        dict.add("c");
        dict.add("b");
        wordLadderII.findLadders("a", "c", dict);
    }

    //use equals method to compare two string
}
