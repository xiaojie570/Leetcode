package leetcode.tree.easy;

/**
 * Created by lenovo on 2019/4/26.
 * 判断给定的树是否是平衡树
 */
public class _110_Balanced_Binary_Tree {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return help(root) != Integer.MAX_VALUE;
    }

    private int help(TreeNode root) {
        if(root == null) return -1;
        int left = help(root.left);
        if(left == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        int right = help(root.right);
        if(right == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        int diff = left - right;
        if(Math.abs(diff) > 1)
            return Integer.MAX_VALUE;
        else
            return Math.max(left,right) + 1;
    }
}
