package testing.leetcode;

import java.util.HashSet;

public class FirstRepeatedWord {
    public static void main(String[] args) {
        String input = "ab cde  _)(&*^&__& fg -- fg hi///jklm - n  cde ab ddd";
        String[] array = input.split("[\\W_]+");
        HashSet<String> set = new HashSet<>();
        for (String word : array) {
            word = word.toLowerCase();
            if (set.contains(word)) {
                System.out.println(word);
                break;
            } else {
                set.add(word);
            }
        }
    }
}
