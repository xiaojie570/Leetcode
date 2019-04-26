package leetcode.tree.easy;

/**
 * Created by lenovo on 2019/4/26.
 * 判断一棵树是否是另一棵树的子树
 */
public class _572_Subtree_of_Another_Tree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return help(s,t,false);
    }

    private boolean help(TreeNode s, TreeNode t, boolean flag) {
        if(s == null && t == null)
            return true;
        else if(s == null || t == null)
            return false;
        if(flag && s.val != t.val)
            return false;
        if(s.val != t.val) {
            return help(s.left,t,false) || help(s.right,t,false);
        } else {
            return ( help(s.left,t.left,true) && help(s.right,t.right,true))
                    || help(s.left,t,false) || help(s.right,t,false);
        }
    }
}
