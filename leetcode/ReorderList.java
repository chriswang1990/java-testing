package leetcode;

import leetcode.ListNode;

/**
 * Created by 1990c on 3/21/2016.
 */
public class ReorderList {
  public void reorderList(ListNode head) {
    // write your code here
    if (head == null || head.next == null) {
      return;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    //find the middle point
    ListNode slow = dummy;
    ListNode fast = dummy;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode mid = slow.next;
    slow.next = null;

    //reverse the latter half;
    ListNode prev = null;
    while (mid != null) {
      ListNode temp = mid.next;
      mid.next = prev;
      prev = mid;
      mid = temp;
    }

    //merge the two linked list
    while (head != null) {
      ListNode temp = head.next;
      head.next = prev;
      if (prev == null) {
        break;
      }
      head = temp;
      temp = prev.next;
      prev.next = head;
      prev = temp;
    }
  }

  public static void main(String[] args) {
    ListNode test = new ListNode(1);
    ListNode dummy = test;
    for (int i = 2; i < 10; i++) {
      test.next = new ListNode(i);
      test = test.next;
    }

    ReorderList s = new ReorderList();
    s.reorderList(dummy);
    System.out.println(dummy);
  }
}
