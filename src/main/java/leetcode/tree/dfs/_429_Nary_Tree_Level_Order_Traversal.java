package leetcode.tree.dfs;

import leetcode.tree.level.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2019/4/22.
 * 多叉树的层次遍历，得到每层的结果  -> bfs
 */
public class _429_Nary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        levelOrderUtil(root, ret, 0);
        return ret;
    }

    private void levelOrderUtil(Node root, List<List<Integer>> ret, int level) {
        if(root == null)  return;
        if(ret.size() == level) {
            ret.add(new ArrayList<Integer>());
        }
        List<Integer> temp = ret.get(level);
        temp.add(root.val);
        for(Node childe: root.children) {
            levelOrderUtil(childe, ret, level + 1);
        }
    }
}
