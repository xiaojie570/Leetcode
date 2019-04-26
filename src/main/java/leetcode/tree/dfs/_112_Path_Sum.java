package leetcode.tree.dfs;

/**
 * Created by lenovo on 2019/4/26.
 * 给定一个树，和一个定值，判断这棵树是否有一条路径的和等于给定的值
 */
public class _112_Path_Sum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        if(root.left == null && root.right == null && sum == root.val)
            return true;
        else
            return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
    }
}
