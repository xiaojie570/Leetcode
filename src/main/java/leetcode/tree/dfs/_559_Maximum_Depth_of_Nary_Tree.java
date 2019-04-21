package leetcode.tree.dfs;

/**
 * Created by lenovo on 2019/4/21.
 * N叉树的最大深度
 */
public class _559_Maximum_Depth_of_Nary_Tree {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        int ret = 1;
        for(Node children: root.children) {
            int temp = maxDepth(children) + 1;
            ret = Math.max(ret, temp);
        }
        return ret;
    }
}
