package leetcode;

import java.util.Random;

/**
 * Quick Sort and Merge Sort
 */
public class QuickAndMergeSort {
    public static void quickSort(int[] array, int start, int end) {
        if (end <= start) {
            return;
        }
        Random rand = new Random();
        int randInt = start + rand.nextInt(end - start + 1);
        int pivot = array[randInt];
        int i = start;
        int j = end;
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (i < end) {
            quickSort(array, i, end);
        }
        if (j > start) {
            quickSort(array, start, j);
        }
    }

    public static void mergeSort(int[] A, int start, int end) {
        if (end == start) {
            return;
        }

        int mid = start + (end - start) / 2;
        mergeSort(A, start, mid);
        mergeSort(A, mid + 1, end);
        int i = start;
        int j = mid + 1;
        int k = 0;
        int[] sorted = new int[end - start + 1];
        while (i <= mid || j <= end) {
            if (i <= mid && j <= end) {
                if (A[i] <= A[j]) {
                    sorted[k] = A[i];
                    i++;
                } else {
                    sorted[k] = A[j];
                    j++;
                }
                k++;
            } else {
                while (i <= mid) {
                    sorted[k] = A[i];
                    i++;
                    k++;
                }
                while (j <= end) {
                    sorted[k] = A[j];
                    j++;
                    k++;
                }
            }
        }
        for (int pos = 0; pos < sorted.length; pos++) {
            A[start + pos] = sorted[pos];
        }
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        int[] array1 = {1,1,0,1, -2, -3, -2, 3, 3, 2};
        quickSort(array1, 0, array1.length - 1);
        int[] array2 = {1,1,0,1, -2, -3, -2, 3, 3, 2};
        mergeSort(array2, 0, array2.length - 1);
        for (int i : array1) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : array2) {
            System.out.print(i + " ");
        }
    }
}
