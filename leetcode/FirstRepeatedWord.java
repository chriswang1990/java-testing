package leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class FirstRepeatedWord {
    public static void main(String[] args) {
        String input = "ab cde  )(&*^&& fg -- fg hi///jklm - n  cde ab ddd";
        String[] array = input.split("\\W+");
        System.out.println(Arrays.toString(array));
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
