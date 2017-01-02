package leetcode;

import leetcode.ListNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by 1990c on 3/23/2016.
 */
public class ReverseListII {
  public ListNode reverseBetween(ListNode head, int m , int n) {
    // find the front part
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    head = dummy;
    for (int i = 1; i < m; i++) {
      head = head.next;
    }
    ListNode frontEnd = head;
    ListNode mid = head.next;

    //find the tail part
    for (int i = m; i <= n; i++) {
      head = head.next;
    }
    ListNode tail = head.next;

    //reverse the middle part
    ListNode prev = tail;
    for (int i = m; i <= n; i++) {
      ListNode temp = mid.next;
      mid.next = prev;
      prev = mid;
      mid = temp;
    }
    frontEnd.next = prev;
    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode test = new ListNode(1);
    ListNode dummy = test;
    for (int i = 2; i < 10; i++) {
      test.next = new ListNode(i);
      test = test.next;
    }

    ReverseListII s = new ReverseListII();
    s.reverseBetween(dummy,2,4);
    System.out.println(dummy);
  }

  public static class Subsets {
      public ArrayList<ArrayList<Integer>> subsets(int[] num) {
          ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
          if(num == null || num.length == 0) {
              return result;
          }
          ArrayList<Integer> list = new ArrayList<Integer>();
          Arrays.sort(num);
          subsetsHelper(result, list, num, 0);
          return result;
      }


      private void subsetsHelper(ArrayList<ArrayList<Integer>> result,
          ArrayList<Integer> list, int[] num, int pos) {
          result.add(new ArrayList<Integer>(list));
          for (int i = pos; i < num.length; i++) {
              if (i != pos && num[i] == num[i-1]) {
                  continue;
              }
              list.add(num[i]);
              subsetsHelper(result, list, num, i + 1);
              list.remove(list.size() - 1);
          }
      }

      public static void main(String[] args) {
          int[] num = {2,1,2,3,2};
          Subsets s = new Subsets();
          System.out.println(s.subsets(num));
      }
  }
}
