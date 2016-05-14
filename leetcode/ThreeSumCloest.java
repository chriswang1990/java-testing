package testing.leetcode;

/**
 * Created by 1990c on 3/28/2016.
 */
public class ThreeSumCloest {
  private void printArray (int[] nums) {
    for (int i : nums) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  public int threeSumClosest(int[] numbers , int target) {
    // write your code here
    if (numbers == null || numbers.length < 3) {
      return 0;
    }

    int length = numbers.length;
    quickSort(numbers, 0, length - 1);
    int cloSum = Integer.MAX_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < length; i++) {
      int j = i + 1;
      int k = length - 1;
      while (j < k) {
        int sum = numbers[j] + numbers[k];
        if (sum == target - numbers[i]) {
          return target;
        }
        if (Math.abs(target - numbers[i] - sum) < min) {
          min = Math.abs(target - numbers[i] - sum);
          cloSum = sum + numbers[i];
        }
        if (sum > target - numbers[i]) {
          k--;
        }
        if (sum < target - numbers[i]) {
          j++;
        }
      }
    }
    return cloSum;
  }
  private int[] merge (int[] A, int[] B) {
    if (A == null) {
      return B;
    }
    if (B == null) {
      return A;
    }
    int len1 = A.length;
    int len2 = B.length;
    int i = 0;
    int j = 0;
    int[] merged = new int[len1 + len2];
    while (i < len1 || j < len2) {
      if (i >= len1) {
        merged[i + j] = B[j];
        j++;
        continue;
      }
      if (j >= len2) {
        merged[i + j] = A[i];
        i++;
        continue;
      }
      if (A[i] <= B[j]) {
        merged[i + j] = A[i];
        i++;
      } else {
        merged[i + j] = B[j];
        j++;
      }
    }
    return merged;
  }

  public double findMedianSortedArrays(int[] A, int[] B) {
    // write your code here
    if (A == null && B == null) {
      return 0;
    }
    int[] merged = merge(A, B);
    int len = merged.length;
    if (len == 0) {
      return 0;
    }
    if (len % 2 == 1) {
      return merged[len / 2];
    } else {
      return (merged[len / 2] + merged[len / 2 - 1]) / 2;
    }

  }

  public void quickSort(int[] numbers, int start, int end) {
    if (start >= end) {
      return;
    }
    int i = start;
    int j = end;
    int flag = numbers[start + (end - start) / 2];
    while (i <= j) {
      while (numbers[i] < flag) {
        i++;
      }
      while (numbers[j] > flag) {
        j--;
      }
      if (i < j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
        i++;
        j--;
      }
    }

    if (start == i || i - 1 == end) {
      return;
    }
    quickSort(numbers, start, i - 1);
    quickSort(numbers, i , end);
  }

  public static void main(String[] args) {
    int[] A = {1, 2, 3, 4, 5, 6};
    int[] B = {2, 3, 4, 5};
    ThreeSumCloest s = new ThreeSumCloest();
    int[] merged = s.merge(A, B);
    s.printArray(merged);
    System.out.println(s.findMedianSortedArrays(A, B));
    int[][] a = new int[10][];

  }


}
