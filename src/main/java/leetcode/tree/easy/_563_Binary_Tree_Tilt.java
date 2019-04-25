package leetcode.tree.easy;

/**
 * Created by lenovo on 2019/4/25.
 * 给出一个二叉树，返回整个树的差值
 * 树节点的差值被定义为所有左子树节点值和所有右子树节点值之和的差的决定只，空节点的差值为0.
 * 整个树的差值被定义为所有节点的差值的总和。
 */
public class _563_Binary_Tree_Tilt {
    int ret = 0;
    public int findTilt(TreeNode root) {
        help(root);
        return ret;
    }

    private int help(TreeNode root) {
        if(root == null)
            return 0;
        int leftSum = 0, rightSum = 0;
        leftSum += help(root.left);
        rightSum += help(root.right);
        ret += Math.abs(leftSum - rightSum);
        return root.val + leftSum + rightSum;
    }
}
