package testing.leetcode;

/**
 * Created by 1990c on 9/28/2016.
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
