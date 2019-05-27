package leetcode.array.dfs;

/**
 * Created by lenovo on 2019/5/27.
 * 已知一棵树的中序和后序遍历，构建这棵树
 */
public class _106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    int pInorder;
    int pPostorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pInorder = inorder.length - 1;
        pPostorder = postorder.length - 1;
        return helper(inorder,postorder, null);
    }

    private TreeNode helper(int[] inorder, int[] postorder, TreeNode end) {
        if(pPostorder < 0)
            return null;
        TreeNode n = new TreeNode(postorder[pPostorder--]);

        if(inorder[pInorder] != n.val)
            n.right = helper(inorder,postorder, n);

        pInorder --;

        if((end == null) || (inorder[pInorder] != end.val))
            n.left = helper(inorder,postorder, end);
        return n;
    }
}
