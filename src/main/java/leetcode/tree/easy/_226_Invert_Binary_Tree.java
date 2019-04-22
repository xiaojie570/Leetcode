package leetcode.tree.easy;

/**
 * Created by lenovo on 2019/4/22.
 * 反转二叉树
 */
public class _226_Invert_Binary_Tree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        if(root.left != null || root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        invertTree(root.right);
        invertTree(root.left);
        return root;
    }
}
