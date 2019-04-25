package leetcode.tree.dfs;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2019/4/25.
 * 该题目是求一颗二叉树的所有路径（从根结点到每个叶子结点）。
 * 返回所有路径组成的List集合。
 *
 * Input:
 * 1
 /   \
 2     3
 \
 5

 Output: ["1->2->5", "1->3"]

 Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 *
 */
public class _257_Binary_Tree_Paths {
    List<String> ret = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return ret;
        help(root,"", ret);
        return ret;
    }

    private void help(TreeNode root, String s, List<String> ret) {
        if(root.left == null && root.right == null)
            ret.add(s + root.val);
        if(root.left != null)
            help(root.left,s + root.val + "->",ret);
        if(root.right != null)
            help(root.right, s + root.val + "->",ret);
    }
}
