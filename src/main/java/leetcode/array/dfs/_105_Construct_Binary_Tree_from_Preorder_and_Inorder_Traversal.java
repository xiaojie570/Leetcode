package leetcode.array.dfs;

/**
 * Created by lenovo on 2019/5/27.
 * 已知一棵树的前序和中序遍历，构造这棵树
 */
public class _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    int pPreorder = 0;
    int pInorder = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder,null);
    }

    private TreeNode helper(int[] preorder, int[] inorder, TreeNode lastNode) {
        if(pPreorder == preorder.length || lastNode != null && lastNode.val == inorder[pInorder])
            return null;
        TreeNode cur = new TreeNode(preorder[pPreorder ++]);  // 拿到前序遍历的前面的结点
        cur.left = helper(preorder,inorder,cur);
        pInorder ++;
        cur.right = helper(preorder,inorder,lastNode);
        return cur;
    }
}
