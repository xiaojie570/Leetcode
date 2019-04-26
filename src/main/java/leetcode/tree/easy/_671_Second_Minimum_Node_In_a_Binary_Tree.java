package leetcode.tree.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by lenovo on 2019/4/26.
 * 找到二叉树中倒数第二小的结点值。
 * 【解题思路】
 *  使用层次遍历（其实这里面使用哪种遍历都是可以的）
 */
public class _671_Second_Minimum_Node_In_a_Binary_Tree {
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null || root.left == null && root.right == null) return -1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int min = root.val, secondMin = root.val;
        while(!queue.isEmpty()) {
            int size = queue.size();
            TreeNode cur = queue.poll();
            if(cur.val < min) {
                secondMin = min;
                min = cur.val;
            } else if(cur.val > min && (cur.val < secondMin || secondMin == min)) {
                secondMin = cur.val;
            }
            if(cur.left != null) queue.offer(root.left);
            if(cur.right != null) queue.offer(root.right);
        }
        return secondMin == min ? -1 : secondMin;
    }
}
