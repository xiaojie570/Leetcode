package leetcode.tree.dfs;

/**
 * Created by lenovo on 2019/4/28.
 * 给定一棵树，找到树根到叶子节点的最小路径
 * 【解题思路】
 * 递归
 */
public class _111_Minimum_Depth_of_Binary_Tree {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null) return minDepth(root.right) + 1;
        if(root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }
}
