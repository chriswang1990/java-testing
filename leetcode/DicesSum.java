package leetcode;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 Throw n dices, the sum of the dices' faces is S. Given n, find the all possible value of S
 along with its probability.

 Example
 Given n = 1, return [ [1, 0.17], [2, 0.17], [3, 0.17], [4, 0.17], [5, 0.17], [6, 0.17]].
 */
public class DicesSum {

    public static List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        List<Map.Entry<Integer, Double>> list = new ArrayList<>();
        double oneSixth = 1 / 6.0;
        if (n == 0) {
            return list;
        }
        for (int i = 1; i < 7; i++) {
            list.add(new AbstractMap.SimpleEntry(i, oneSixth));
        }
        if (n == 1) {
            return list;
        } else {
            int k = 2;
            while (k <= n) {
                List<Map.Entry<Integer, Double>> newList = new ArrayList<>();
                for (int i = k; i <= 6 * k; i++) {
                    newList.add(new AbstractMap.SimpleEntry(i, (double) 0));
                }
                for (Map.Entry<Integer, Double> entry : list) {
                    for (int i = 1; i <= 6; i++) {
                        Integer newSum = entry.getKey() + i;
                        System.out.println("size: " + list.size());
                        System.out.println(entry.getKey() + " " + newSum);
                        Double newValue = entry.getValue() * oneSixth +
                              newList.get(newSum - k).getValue();
                        newList.get(newSum - k).setValue(newValue);
                    }
                }
                list = new ArrayList<>(newList);
                k++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Map.Entry<Integer, Double>> list = dicesSum(2);
    }
}
