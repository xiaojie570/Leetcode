package leetcode.tree.dfs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lenovo on 2019/4/21.
 * 对比两棵树的叶子结点是否相同，如果完全相同则返回true
 * 【解题思路】 使用dfs的方法。
 *  1. 遍历每棵树，将树的叶子节点放到ArrayList中。
 *  2. 然后比较ArrayList是否相同即可。
 */
public class _872_Leaf_Similar_Trees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        findLeaf(root1,list1);
        findLeaf(root2,list2);
        boolean ret = false;
        Iterator i1 = list1.iterator();
        Iterator i2 = list2.iterator();
        while(i1.hasNext() && i2.hasNext()) {
            if(! i1.next().equals(i2.next()))
                return false;
        }
        return true;
    }

    private void findLeaf(TreeNode root, List<Integer> list1) {
        if(root == null) return;
        if(root.left == null && root.right == null)
            list1.add(root.val);
        findLeaf(root.left,list1);
        findLeaf(root.right,list1);
    }
}
