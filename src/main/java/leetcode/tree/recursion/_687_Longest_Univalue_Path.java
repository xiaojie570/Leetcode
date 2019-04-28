package leetcode.tree.recursion;


/**
 * Created by lenovo on 2019/4/28.
 * 找出二叉树中，最长的链路长度（链路由相同的值构成，可以不包含根节点）
 */
public class _687_Longest_Univalue_Path {
    int ret = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        if(root != null)
            help(root);
        return ret;
    }

    private int help(TreeNode root) {
        int l = root.left != null ? help(root.left) : 0;
        int r = root.right != null ? help(root.right) : 0;
        int retl = root.left != null && root.left.val == root.val ? l + 1 : 0;
        int retr = root.right != null && root.right.val == root.val ? r + 1 : 0;
        ret = Math.max(ret,retl + retr);
        return Math.max(retl,retr);

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(1);
        treeNode.left = treeNode1;
        treeNode1.left = treeNode2;
        _687_Longest_Univalue_Path test = new _687_Longest_Univalue_Path();
        int ret = test.longestUnivaluePath(treeNode);
        System.out.println(ret);
    }
}
