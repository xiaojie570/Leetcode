package leetcode.tree.easy;

/**
 * Created by lenovo on 2019/4/23.
 * 判断两个二叉树是否相等
 */
public class _100_Same_Tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        else if(p == null) return false;
        else if(q == null) return false;
        if(p.val == q.val)
            return isSameTree(p.right,q.right) && isSameTree(p.left,q.left);
        return false;
    }
}
