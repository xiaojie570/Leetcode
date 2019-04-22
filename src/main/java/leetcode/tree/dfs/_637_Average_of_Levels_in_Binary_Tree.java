package leetcode.tree.dfs;

import java.util.*;

/**
 * Created by lenovo on 2019/4/22.
 * 返回每层的平均值
 */
public class _637_Average_of_Levels_in_Binary_Tree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<Double>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            for(int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                sum += treeNode.val;
                if(treeNode.left != null) queue.offer(treeNode.left);
                if(treeNode.right != null) queue.offer(treeNode.right);
            }
            list.add((double)sum / size);
        }
        return list;
    }
}
