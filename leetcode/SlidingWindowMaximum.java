package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by cwang on 1/26/2017.
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<Integer>();
        int len = nums.length;
        if (k == 0 || len == 0) {
            return new int[0];
        }
        int[] ans = new int[len - k + 1];
        for (int i = 0; i < len; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                ans[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }
}
