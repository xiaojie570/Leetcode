package leetcode.tree.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lenovo on 2019/4/20.
 * 判断给定的二叉树是否是所有节点的元素值都相等
 * 【解题思路】
 *      1. 首先因为是所有节点的元素值都相等，所以可以将根节点存储下来，然后传递给私有方法，去递归的判断根节点的左孩子和右孩子的值是否和val根节点的值相同
 *
 *    CSDN: https://blog.csdn.net/xiaojie_570/article/details/90691836
 */
public class _965_Univalued_Binary_Tree {
    public boolean isUnivalTree(TreeNode root) {
        return (root == null) || isValid(root,root.val);
    }

    private boolean isValid(TreeNode root, Integer val) {
        if(root == null) return true;
        if(root.val != val) return false;
        return isValid(root.left,val) && isValid(root.right,val);
    }
}
