package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 Construct minimum number by reordering a given non-negative integer array. Arrange them such that
 they form the minimum number.

 Example
 Given [3, 32, 321], there are 6 possible numbers can be constructed by reordering the array:

 3+32+321=332321
 3+321+32=332132
 32+3+321=323321
 32+321+3=323213
 321+3+32=321332
 321+32+3=321323
 So after reordering, the minimum number is 321323, and return it.
 */
public class ConstructMinNum {
    public String minNumber(int[] nums) {
        // Write your code here
        Integer[] array = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = nums[i];
        }
        Arrays.sort(array, new Comparator<Integer>(){
            @Override
            public int compare(Integer a,  Integer b) {
                int ab = Integer.parseInt(a + "" + b);
                int ba = Integer.parseInt(b + "" + a);
                return ab - ba;
            }
        });
        String ans = "";
        for (int i : array) {
            if (i == 0) {
                continue;
            }
            ans += i;
        }
        if (ans.isEmpty()) {
            ans = "0";
        }
        return ans;
    }

}
