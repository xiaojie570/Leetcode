package leetcode.tree.easy;

/**
 * Created by lenovo on 2019/4/26.
 * 找到二叉树中的子路径条数，使得该子路径值之和等于给定和。
 */
public class _437_Path_Sum_III {
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return help(root,sum) + pathSum(root.left,sum) + pathSum(root.right,sum) ; // 每一条路径，可能不包含根节点
    }

    private int help(TreeNode root, int sum) {
        if(root == null) return 0;
        return  (root.val == sum ? 1 : 0)
                + help(root.left,sum - root.val)
                + help(root.right,sum - root.val);
    }
}
