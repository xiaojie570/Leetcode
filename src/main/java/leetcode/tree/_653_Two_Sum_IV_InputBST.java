package leetcode.tree;

/**
 * Created by lenovo on 2019/4/11.
 */
public class _653_Two_Sum_IV_InputBST {
    public boolean findTarget(TreeNode root, int k) {
        return traverse(root, root, k);
    }
    public boolean traverse(TreeNode root, TreeNode curNode, int k) {
        if (curNode == null) return false;
        return traverse(root, curNode.left, k) || traverse(root, curNode.right, k) || findValue(root, k - curNode.val, curNode);
    }
    //binary search find value 从BST树中找到想要的值
    /**
     * @param root  树根
     * @param val 想要找的节点的值
     * @param skipNode  当前节点的值
     * @return
     */
    public boolean findValue(TreeNode root, int val, TreeNode skipNode) {
        if (root == null) return false;
        if (root.val == val && root != skipNode) return true;
        if (root.val > val) {
            return findValue(root.left, val, skipNode);
        } else
            return findValue(root.right, val, skipNode);
    }
}
