package testing.leetcode;

import com.sun.istack.internal.Nullable;

/**
 * Created by 1990c on 11/3/2016.
 */
public class LowestCommonAncestorIII {
  public static TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
    // write your code here
    if (A == null || B == null) {
      return null;
    }
    return helper(root, A, B).lca;
  }

  public static Result helper(TreeNode root, TreeNode A, TreeNode B) {
    if (root == null) {
      return new Result(false, false, null);
    }
    Result left = helper(root.left, A, B);
    Result right = helper(root.right, A, B);
    boolean foundA = left.foundA || right.foundA || root.val == A.val;
    boolean foundB = left.foundB || right.foundB || root.val == B.val;
    TreeNode lca = null;
    if (foundA && foundB) {
      if (left.lca != null) {
        lca = left.lca;
      } else if (right.lca != null) {
        lca = right.lca;
      } else {
        lca = root;
      }
    }
    return new Result(foundA, foundB, lca);
  }

  public static void main(String[] args) {
    lowestCommonAncestor3(null, new TreeNode(5), new TreeNode(3));
  }
}

class Result {

  boolean foundA;
  boolean foundB;
  TreeNode lca;

  public Result(boolean foundA, boolean foundB, @Nullable TreeNode lca) {
    this.foundA = foundA;
    this.foundB = foundB;
    this.lca = lca;
  }
}
