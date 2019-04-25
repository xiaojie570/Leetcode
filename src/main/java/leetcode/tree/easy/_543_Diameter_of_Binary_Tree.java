package leetcode.tree.easy;

/**
 * Created by lenovo on 2019/4/25.
 * 给定二叉树，计算它的直径的长度。二叉树的直径为树中任意两个节点的最长路径的长度。这个路径可能通过，也可能不通过根节点。
 */
public class _543_Diameter_of_Binary_Tree {
    int depth = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        help(root);
        return depth;
    }

    private int help(TreeNode root) {
        if(root == null) return 0;
        int left = help(root.left);
        int right = help(root.right);
        depth = Math.max(depth, left + right);
        return Math.max(left,right) + 1;
    }
}
