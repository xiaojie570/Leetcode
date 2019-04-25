package leetcode.tree.easy;

/**
 * Created by lenovo on 2019/4/25.
 * 返回给定树的所有左孩子之和
 */
public class _404_Sum_of_Left_Leaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null || (root.left == null && root.right == null))
            return 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) // 当前节点的左孩子是叶子节点
                sum += root.left.val;
            else  // 当前节点的左节点不是叶子节点
                sum += sumOfLeftLeaves(root.left);
        }
        if (root.right != null)
            sum += sumOfLeftLeaves(root.right);
        return sum;
    }
}
