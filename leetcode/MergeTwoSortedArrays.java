package leetcode;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static int[] mergeTwoSortedArrays1(int[] arr1, int[]arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int i = len1 - len2 - 1;
        int j = len2 - 1;
        int k = len1 - 1;
        while (i >= 0 && j >= 0) {
            if (arr1[i] >= arr2[j]) {
                arr1[k--] = arr1[i--];
            } else {
                arr1[k--] = arr2[j--];
            }
        }
        while (i >= 0) {
            arr1[k--] = arr1[i--];
        }
        while (j >= 0) {
            arr1[k--] = arr2[j--];
        }
        return arr1;
    }

    public static int[] mergeTwoSortedArrays2(int[] arr1, int[]arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] ans = new int[len1 + len2];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < len1 && j < len2) {
            if (arr1[i] <= arr2[j]) {
                ans[k++] = arr1[i++];
            } else {
                ans[k++] = arr2[j++];
            }
        }
        while (i < len1) {
            ans[k++] = arr1[i++];
        }
        while (j < len2) {
            ans[k++] = arr2[j++];
        }
        return ans;
    }

    public static void mergeTwoSortedArrays3(int[] arr1, int[]arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {2, 4, 6, 10, 0, 0, 0, 0, 0};
        int[] arr2 = new int[] {1, 1, 2, 3, 6};
        int[] arr3 = new int[] {2, 6, 7};
        int[] arr4 = new int[] {3, 3, 4};
        System.out.println(Arrays.toString(mergeTwoSortedArrays1(arr1, arr2)));
        System.out.println(Arrays.toString(mergeTwoSortedArrays2(arr3, arr4)));
    }
}