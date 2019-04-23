package leetcode.tree.easy;

/**
 * Created by lenovo on 2019/4/23.
 * 二叉树的两个节点判断是不是堂兄弟
 * 【解题思路】
 *      堂兄弟应该是
 *      1. 父亲节点不同
 *      2. 深度一样
 */
public class _993_Cousins_in_Binary_Tree {
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode dummy = new TreeNode(0);
        int[] ret = new int[4];
        help(root, dummy, x, y, 0, ret);
        return ret[1] == ret[3] && ret[2] != ret[0];
    }

    private void help(TreeNode node, TreeNode parent, int x, int y, int depth, int[] ret) {
        if(node == null) return;
        if(x == node.val) {
            ret[0] = parent.val;
            ret[1] = depth;
        } else if(y == node.val) {
            ret[2] = parent.val;
            ret[3] = depth;
        }
        help(node.left,node,x,y,depth + 1,ret);
        help(node.right,node,x,y,depth + 1,ret);
    }
}
