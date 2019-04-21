package leetcode.tree.easy;

/**
 * Created by lenovo on 2019/4/21.
 * 返回二叉树的深度
 */
public class _104_Maximum_Depth_of_Binary_Tree {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int ret = 1;
        if(root.left == null && root.right == null) return 1;
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        ret = Math.max(left,right);
        return ret;
    }
}
