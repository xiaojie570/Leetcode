package leetcode.tree.dfs;

/**
 * Created by lenovo on 2019/4/26.
 * 判断给定的树是否是对称的树
 * 【解题思路】
 *  递归，就是一个新的判断规则
 *  1. 如果左右树都为空，则符合
 *  2. 如果左树为空右树不为空，或者左树不为空右树为空，则不符合
 *  3. 如果左右树的值相等，则继续递归判断下面的值是否对称
 */
public class _101_Symmetric_Tree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null || root.left == null && root.right == null) return true;
        return help(root.left,root.right);
    }

    private boolean help(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        else if (left == null || right == null)
            return false;
        if(left.val == right.val)
            return help(left.left,right.right) && help(left.right,right.left);
        else
            return false;
    }
}
