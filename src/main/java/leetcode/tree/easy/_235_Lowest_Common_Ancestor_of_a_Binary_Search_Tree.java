package leetcode.tree.easy;

/**
 * Created by lenovo on 2019/4/26.
 * 给定一棵BST树，两个节点，找到两个节点最近的公共祖先
 *
 */
public class _235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       while(root != null) {
           if(root.val > p.val && root.val < q.val)
               root = root.left;
           else if(root.val < p.val && root.val < q.val)
               root = root.right;
           else
               break;
       }
        return root;
    }
}
