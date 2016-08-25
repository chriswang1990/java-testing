package testing.leetcode;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by 1990c on 8/25/2016.
 */
public class Pangram {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        HashSet<Integer> set = new HashSet<>();
        for (char c = 'a'; c <= 'z'; c++) {
            set.add((int) c);
            System.out.print((int)c + " ");
        }
        System.out.println(set.size());
        for (int k = 0; k < line.length(); k++) {
            char c = line.charAt(k);
            int i = (int) c;
            int j = (int) c + 32;
            if (set.contains(i)) {
                set.remove(i);
            } else if (set.contains(j)) {
                set.remove(j);
            }
        }
        if (set.isEmpty()) {
            System.out.println("pangram");
        } else {
            System.out.println("not pangram");
        }
        scanner.close();
    }
}
