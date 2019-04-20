package leetcode.tree.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2019/4/20.
 * 多维树的后序遍历
 * 【解题思路】
 *      就是讲多维树的前序遍历的增加返回list的操作放到遍历的后面就可以了。
 */
public class _590_Nary_Tree_Postorder_Traversal {
    public List<Integer> postorder(Node root) {
        List<Integer> ret = new ArrayList<Integer>();
        if(root == null) return ret;
        postOrder(root,ret);
        ret.add(root.val);
        return ret;
    }

    private void postOrder(Node root, List<Integer> ret) {
        if(root == null) return;
        for(Node children : root.children) {
            postOrder(children,ret);
            ret.add(children.val);
        }
    }
}
