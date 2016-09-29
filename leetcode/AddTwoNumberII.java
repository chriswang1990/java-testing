package testing.leetcode;

/**
 You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in
 forward order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and
 returns the sum as a linked list.

 Example
 Given 6->1->7 + 2->9->5. That is, 617 + 295.
 Return 9->1->2. That is, 912.
 */
public class AddTwoNumberII {
  /**
   * @param l1: the first list
   * @param l2: the second list
   * @return: the sum list of l1 and l2
   */
  public ListNode addLists2(ListNode l1, ListNode l2) {
    // write your code here
    l1 = reverse(l1);
    l2 = reverse(l2);
    ListNode dummy = new ListNode(0);
    int sum = 0;

    while (true) {
      if (l1 != null && l2 != null) {
        sum += l1.val + l2.val;
        l1 = l1.next;
        l2 = l2.next;
      } else if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      } else if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      } else {
        if (sum == 0) {
          break;
        }
      }
      ListNode temp = dummy.next;
      ListNode cur = new ListNode(sum % 10);
      sum /= 10;
      dummy.next = cur;
      cur.next = temp;
    }
    return dummy.next;
  }

  public ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode temp = head.next;
      head.next = prev;
      prev = head;
      head = temp;
    }
    return prev;
  }
}
