package leetcode;

/**
 Given two integer arrays sorted in ascending order and an integer k. Define sum = a + b, where a is an element from the
 first array and b is an element from the second one. Find the kth smallest sum out of all possible sums.
 Example
 Given [1, 7, 11] and [2, 4, 6].

 For k = 3, return 7.

 For k = 4, return 9.

 For k = 8, return 15.
 */
public class KSmallestElement {
    public static int kthSmallestSum(int[] A, int[] B, int k) {
        // Write your code here
        int aInd = 0;
        int bInd = 0;
        return helper(A, B, aInd, bInd, k);
    }

    public static int helper(int[] A, int[] B, int aInd, int bInd, int k) {
        if (aInd >= A.length) {
            return B[bInd + k - 1];
        }
        if (bInd >= B.length) {
            return A[aInd + k - 1];
        }
        if (k == 1) {
            return Math.min(A[aInd], B[bInd]);
        }
        if (aInd + k / 2 - 1 >= A.length) {
            return helper(A, B, aInd, bInd + k / 2, k - k / 2);
        } else if (bInd + k / 2 - 1 >= B.length) {
            return helper(A, B, aInd + k / 2, bInd, k - k / 2);
        }
        if (A[aInd + k / 2 - 1] < B[bInd + k / 2 - 1]) {
            return helper(A, B, aInd + k / 2, bInd, k - k / 2);
        } else {
            return helper(A, B, aInd, bInd + k / 2, k - k / 2);
        }
    }

    public static void main(String[] args) {
        int[] A = new int[] {1, 7 ,11};
        int[] B = new int[] {2, 4, 6};
        System.out.println(kthSmallestSum(A, B , 3));
    }
}
