package leetcode.tree.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2019/4/20.
 * 多维树的前序遍历
 * 【解题思路】
 *    1. 首先要判断给定的树是否是空树，如果是空树，就直接返回false
 *    2. 写一个方法，用来递归将树中的元素放到List中。
 *
 *    CSDN: https://blog.csdn.net/xiaojie_570/article/details/90759590
 */
public class _589_N_ary_Tree_Preorder_Traversal {
    public List<Integer> preorder(Node root) {
        List<Integer> ret = new ArrayList<Integer>();
        if(root == null) return ret;
        preOrder(root,ret);
        return ret;
    }

    private void preOrder(Node root, List<Integer> ret) {
        if(root == null) return;
        ret.add(root.val);
        for (Node children: root.children) {
            if(children != null)
                preOrder(children,ret);
        }
    }
}
