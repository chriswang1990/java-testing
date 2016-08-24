package testing.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 Given an array of strings, return all groups of strings that are anagrams.

 Example
 Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].
 Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].
 */
public class Anagrams {
    public static List<String> anagrams(String[] strs) {
        List<String> ans = new ArrayList<>();
        int len = strs.length;
        if (len <= 1) {
            return ans;
        }
        int[][] charArrays = new int[26][len];
        for (int i = 0; i < len; i++) {
            charArrays[i] = countChar(strs[i]);
        }
        boolean[] counted = new boolean[len];
        for (int i = 0; i < len; i++) {
            counted[i] = false;
        }
        for (int i = 0; i < len; i++) {
            if (counted[i]) {
                continue;
            }
            for (int j = i + 1; j < len; j++) {
                if (counted[j]) {
                    continue;
                }
                if (Arrays.equals(charArrays[i], charArrays[j])) {
                    ans.add(strs[i]);
                    ans.add(strs[j]);
                    counted[i] = true;
                    counted[j] = true;
                }
            }
        }
        return ans;
    }

    public static int[] countChar(String a) {
        int[] charArray = new int[26];
        for (int i = 0; i < 26; i++) {
            charArray[i] = 0;
        }
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            int pos = (int) c - 97;
            charArray[pos] += 1;
        }
        return charArray;
    }

    public static void main(String[] args) {
        String[] strs = {"tea","and","ate","eat","den"};
        List<String> ans = anagrams(strs);
        for (String s : ans) {
            System.out.println(s);
        }
    }
}
