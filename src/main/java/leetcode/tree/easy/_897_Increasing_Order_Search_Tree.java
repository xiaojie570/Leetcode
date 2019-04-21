package leetcode.tree.easy;

/**
 * Created by lenovo on 2019/4/21.
 * 将二叉树改为只有右孩子的树
 * 【解题思路】
 *      使用递归的方式，类似于中序遍历，只是把中序遍历的中间输出节点的步骤改为更改节点的步骤。很好的题
 */
public class _897_Increasing_Order_Search_Tree {
    TreeNode pre, head;
    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return head;
    }

    private void inOrder(TreeNode root) {
        if(root == null)
            return;
        inOrder(root.left);
        if(pre == null)  // 这个是更新根元素的。
            head = root; // 只有根元素遍历的时候才会走到这里来。
        else
            pre.right = root;
        root.left = null;
        pre = root; // 目的是记录当前节点的上一个节点，这样才能递归遍历
        inOrder(root.right);
    }

    public static void main(String[] args) {
        _897_Increasing_Order_Search_Tree test = new _897_Increasing_Order_Search_Tree();
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t2.right = t3;
        test.increasingBST(t1);
    }
}
