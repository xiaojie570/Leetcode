package leetcode.tree.easy;

/**
 * Created by lenovo on 2019/4/20.
 * 题目描述：
 *      合并两棵二叉树，有一些结点会重叠而有一些不会，现在想把重叠的结点值变为两者值相加，不重叠的直接用，构建出新的树
 * 【解题思路】 递归
 */
public class _617_Merge_Two_Binary_Trees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return null;
        else if(t1 == null) return t2;
        else if(t2 == null) return t1;
        TreeNode ret = new TreeNode(t1.val + t2.val);
        ret.left = mergeTrees(t1.left,t2.left);
        ret.right = mergeTrees(t1.right,t2.right);
        return ret;
    }
}
