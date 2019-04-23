package leetcode.tree.construct_string;

/**
 * Created by lenovo on 2019/4/23.
 * 将给定的二叉树组建成字符串，每个节点都用（）包起来。
 */
public class _606_Construct_String_from_Binary_Tree {
    public String tree2str(TreeNode t) {
        if(t == null) return "";
        StringBuilder sb = new StringBuilder();
        inOrder(t, sb);
        return sb.toString();
    }

    private void inOrder(TreeNode t, StringBuilder sb) {
        if(t == null) return;
        sb.append(t.val);  // 首先将当前节点放进来
        if(t.left != null) { // 如果当前节点的左孩子不为空，则递归它的左孩子
            sb.append("(");
            inOrder(t.left,sb);
            sb.append(")");
        } else if(t.left == null && t.right != null) { // 如果当前节点没有左孩子只有右孩子，则需要用 （）填充它的左孩子
            sb.append("()");
        }
        if(t.right != null) {  // 判断当前节点的右孩子是否为空，如果不为空，则递归它的右孩子
            sb.append("(");
            inOrder(t.right,sb);
            sb.append(")");
        }
    }
}
