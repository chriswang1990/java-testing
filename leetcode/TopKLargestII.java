package testing.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by 1990c on 9/24/2016.
 */
public class TopKLargestII {
  PriorityQueue<Integer> pq;
  int k;

  public TopKLargestII(int k) {
    pq = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
      @Override
      public int compare(Integer a, Integer b) {
        return b - a;
      }
    });
    this.k = k;
  }

  public void add(int num) {
    // Write your code here
    pq.offer(num);
  }

  public List<Integer> topk() {
    // Write your code here
    PriorityQueue<Integer> pqCopy = new PriorityQueue<Integer>(pq);
    List<Integer> ans = new ArrayList<Integer>();
    for (int i = 0; i < k; i++) {
      System.out.println(pqCopy.peek());
      ans.add(pq.poll());
    }
    return ans;
  }

  public static void main(String[] args) {
    TopKLargestII tk = new TopKLargestII(3);
    tk.add(3);
    tk.add(10);
    System.out.println(tk.topk());
  }
}
