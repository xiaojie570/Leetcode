package leetcode.tree.easy;

/**
 * Created by lenovo on 2019/4/20.
 * 在一个BST树中查找是否有给定的元素 val
 * 【解题思路】
 *      递归 二分查找
 */
public class _700_Search_in_a_Binary_Search_Tree {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        if(root.val < val)
            return searchBST(root.right,val);
        else
            return searchBST(root.left,val);
    }
}
