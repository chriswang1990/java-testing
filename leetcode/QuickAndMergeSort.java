package testing.leetcode;

/**
 * Quick Sort and Merge Sort
 */
public class QuickAndMergeSort {
    public static void quickSort(int[] array, int start, int end) {
        if (end <= start) {
            return;
        }
        int pivot = array[start];
        int pos = start + 1;
        for (int i = start + 1; i <= end; i++) {
            if (array[i] >= pivot) {
                continue;
            }
            swap(array, i, pos);
            pos++;
        }
        swap(array, start, pos - 1);
        quickSort(array, start, pos - 2);
        quickSort(array, pos, end);
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void mergeSort(int[] array, int start, int end) {
        if (end == start) {
            return;
        }
        if (end - start == 1) {
            if (array[start] > array[end]) {
                swap(array, start, end);
            }
        }
        int mid = start + (end - start) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);
        int i = start;
        int j = mid + 1;
        int k = 0;
        int[] afterSort = new int[end - start + 1];
        while (i <= mid || j <= end) {
            if (i > mid || (j <= end && array[j] < array[i])) {
                afterSort[k] = array[j];
                j++;
            } else {
                afterSort[k] = array[i];
                i++;
            }
            k++;
        }
        for (int pos = 0; pos < afterSort.length; pos++) {
            array[start + pos] = afterSort[pos];
        }
    }


    public static void main(String[] args) {
        int[] array1 = {3, 3, 3, 3, 3, 2, 2, -1000, 2999, 2999, 3000};
        quickSort(array1, 0, array1.length - 1);
        int[] array2 = {3, 2, 3, 2, 3, 2, 2};
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
