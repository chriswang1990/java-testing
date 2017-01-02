package leetcode;

public class SwapNodes {
  /**
   * @param head a ListNode
   * @oaram v1 an integer
   * @param v2 an integer
   * @return a new head of singly-linked list
   */
  public static ListNode swapNodes(ListNode head, int v1, int v2) {
    // Write your code here
    if (head == null) {
      return null;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode cur = dummy;
    boolean found1 = false;
    boolean found2 = false;
    ListNode prev = new ListNode(0);
    while (cur.next != null) {
      if (cur.next.val == v1) {
        if (found2) {
          ListNode node1 = cur.next;
          ListNode node2 = prev.next;
          if (prev.next == cur) {
            node2.next = node1.next;
            node1.next = node2;
            prev.next = node1;
          } else {
            ListNode temp = node2.next;
            node2.next = node1.next;
            node1.next = temp;
            prev.next = node1;
            cur.next = node2;
          }
          return dummy.next;
        } else {
          prev = cur;
          found1 = true;
        }
      } else if (cur.next.val == v2) {
        if (found1) {
          ListNode node1 = prev.next;
          ListNode node2 = cur.next;
          if (prev.next == cur) {
            node1.next = node2.next;
            node2.next = node1;
            prev.next = node2;
          } else {
            ListNode temp = node1.next;
            node1.next = node2.next;
            node2.next = temp;
            cur.next = node1;
            prev.next = node2;
          }
          return dummy.next;
        } else {
          prev = cur;
          found2 = true;
        }
      }
      cur = cur.next;
    }
    return dummy.next;
  }

  public static ListNode addNode(ListNode cur, int val) {
    cur.next = new ListNode(val);
    cur = cur.next;
    return cur;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(10);
    ListNode cur = head;
    cur = addNode(cur, 8);
    cur = addNode(cur, 7);
    cur = addNode(cur, 6);
    cur = addNode(cur, 4);
    cur = addNode(cur, 3);

    ListNode ans = swapNodes(head, 8, 10);
    while (ans != null) {
      System.out.print(ans.val + " ");
      ans = ans.next;
    }
  }
}
