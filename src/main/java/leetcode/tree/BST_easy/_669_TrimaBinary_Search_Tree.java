package leetcode.tree.BST_easy;

/**
 * Created by lenovo on 2019/4/21.
 * 给定一个二叉树BST，和一个范围[L,R]，要求BST只保留在[L,R]范围的树
 */
public class _669_TrimaBinary_Search_Tree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null) return root;

        if(root.val < L) return trimBST(root.right,L,R);
        if(root.val > R) return trimBST(root.left,L,R);

        root.left = trimBST(root.left,L,R);
        root. right = trimBST(root.right,L,R);
        return root;
    }
}
