package leetcode;

import java.util.ArrayList;

/**
 * Created by 1990c on 3/6/2016.
 */
public class OrderLevel {
  /**
   * @param root: The root of binary tree.
   * @return: Level order a list of lists of integer
   */

  public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    // write your code here
    ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    if (root == null) {
      return results;
    }

    orderHelper(0, root, results);
    return results;
  }

  private void orderHelper(int i, TreeNode root, ArrayList<ArrayList<Integer>> results) {
    if (root == null) {
      return;
    }

    if (results.size() == i) {
      results.add(new ArrayList<Integer>());
    }
    results.get(i).add(root.val);
    orderHelper(i + 1, root.left, results);
    orderHelper(i + 1, root.right, results);
    return;
  }

  public static void main(String[] args) {
    OrderLevel s = new OrderLevel();
  }

}


