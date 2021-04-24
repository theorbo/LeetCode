package Tree;


/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 * <p>
 * The path sum of a path is the sum of the node's values in the path.
 * <p>
 * Given the root of a binary tree, return the maximum path sum of any path.
 */


public class BinaryTreeMaxPathSum {

  public int maxPathSum(TreeNode root) {
    Res res = new Res();
    res.val = Integer.MIN_VALUE;
    solve(root, res);
    return res.val;
  }

  int solve(TreeNode root, Res res) {

    if (root == null) {
      return 0;
    }

    int l = solve(root.left, res);
    int r = solve(root.right, res);

    int temp = Math.max(Math.max(l, r) + root.val, root.val);
    int ans = Math.max(temp, l + r + root.val);
    res.val = Math.max(res.val, ans);
    return temp;
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  class Res {
    int val;
  }
}
