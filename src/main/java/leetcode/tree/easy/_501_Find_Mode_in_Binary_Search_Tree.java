package leetcode.tree.easy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lenovo on 2019/4/26.
 * 找到给定的BST树中出现次数最多的元素
 */
public class _501_Find_Mode_in_Binary_Search_Tree {
    List<Integer> list = new ArrayList<Integer>();
    private int currVal;
    private int currCount = 0;
    private int maxCount = 0;

    public int[] findMode(TreeNode root) {
        help(root);
        int size = list.size();
        int[] ret = new int[size];
        for(int i = 0; i < ret.length; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
    private void hanldeValue(int val) {
        if(currVal != val) {
            currCount = 0;
            currVal = val;
        }
        currCount ++;
        if(currCount > maxCount) {
            maxCount = currCount;
            list.clear();
            list.add(currVal);
        } else if(currCount == maxCount)
            list.add(currVal);
    }

    private void help(TreeNode root) {
        if(root == null)
            return;
        help(root.left);
        hanldeValue(root.val);
        help(root.right);
    }
}
