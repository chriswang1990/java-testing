package leetcode;

/**
 * Created by 1990c on 3/21/2016.
 */
public class ListNode {
  int val;
  ListNode next;
  ListNode(int val) {
    this.val = val;
    this.next = null;
  }

  @Override
  public String toString() {
    ListNode node = this;
    String result = "";
    while (node != null) {
      result += node.val + " ";
      node = node.next;
    }
    result += "null";
    return result;
  }
}
