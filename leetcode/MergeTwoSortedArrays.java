package leetcode;

import java.util.Arrays;

/**
 * Created by cwang on 1/1/2017.
 */
public class MergeTwoSortedArrays {
    public static int[] mergeTwoSortedArrays(int[] arr1, int[]arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int i = len1 - 1;
        int j = len2 - len1 - 1;
        for (int k = len2 - 1; k >= 0; k--) {
            if (i < 0) {
                arr2[k] = arr2[j];
                j--;
            } else if (j < 0) {
                arr2[k] = arr1[i];
                i--;
            } else {
                if (arr1[i] >= arr1[j]) {
                    arr2[k] = arr1[i];
                    i--;
                } else {
                    arr2[k] = arr2[j];
                    j--;
                }
            }
        }
        return arr2;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {2, 4, 6, 10};
        int[] arr2 = new int[] {2, 3, 6, 0, 0, 0, 0};
        System.out.println(Arrays.toString(mergeTwoSortedArrays(arr1, arr2)));

    }
}