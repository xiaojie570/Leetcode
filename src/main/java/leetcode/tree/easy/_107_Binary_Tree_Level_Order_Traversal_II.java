package leetcode.tree.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2019/4/25.
 * 从最底层往上面进行层次遍历
 * 【解题思路】
 *  1. 先正常的方式进行层次遍历，然后将遍历后的结果再逆序就可以了。
 *  2. 层次遍历：找到每一层的level标志。
 */
public class _107_Binary_Tree_Level_Order_Traversal_II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(root == null) return ret;
        help(root,ret,0);
        reverse(ret);
        return ret;
    }

    private void reverse(List<List<Integer>> ret) {
        int size = ret.size();
        for(int i = 0; i < size / 2; i++) {
            List<Integer> list = ret.get(i);
            ret.set(i, ret.get(size - i - 1));
            ret.set(size - i - 1,list);
        }
    }

    private void help(TreeNode root, List<List<Integer>> ret, int level) {
        if(root == null)
            return;
        if(ret.size() == level)
            ret.add(new ArrayList<Integer>());
        ret.get(level).add(root.val);
        help(root.left,ret,level + 1);
        help(root.right,ret,level + 1);
    }

}
