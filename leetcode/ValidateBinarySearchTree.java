package testing.leetcode;
import leetcode.TreeNode;

import java.util.ArrayList;
/**
 * Created by 1990c on 3/3/2016.
 */
public class ValidateBinarySearchTree {
  /**
   * @param root: The root of binary tree.
   * @return: True if the binary tree is BST, or false
   */
  public boolean isValidBST(TreeNode root) {
    // write your code here
    if (root == null) {
      return true;
    }

    ArrayList<Integer> inorderList = new ArrayList<Integer>();
    inorderHelper(root, inorderList);
    int size = inorderList.size();
    if (size == 1) {
      return true;
    } else {
      for (int i = 1; i < size; i++) {
        if (inorderList.get(i) <= inorderList.get(i - 1)) {
          return false;
        }
      }
      return true;
    }
  }

  private void inorderHelper(TreeNode root, ArrayList<Integer> list) {
    if (root == null) {
      return;
    }
    inorderHelper(root.left, list);
    list.add(root.val);
    inorderHelper(root.right, list);
  }
  private boolean isPalin(String s) {
    int len = s.length();
    if (len == 0 || len == 1) {
      return true;
    }
    int i = 0;
    int j = len - 1;
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(2);
    TreeNode left = new TreeNode(1);
    root.left = left;
    ValidateBinarySearchTree s = new ValidateBinarySearchTree();
    System.out.println((int) "A".charAt(0));
  }
}

