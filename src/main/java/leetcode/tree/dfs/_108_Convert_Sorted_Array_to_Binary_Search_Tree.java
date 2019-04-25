package leetcode.tree.dfs;

/**
 * Created by lenovo on 2019/4/25.
 * 将给定的有序数组转换为BST树
 */
public class _108_Convert_Sorted_Array_to_Binary_Search_Tree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return bfs(nums,0,nums.length - 1);
    }

    private TreeNode bfs(int[] nums, int left, int right) {
        if(left > right)
            return null;
        int medium = (left + right) / 2;
        TreeNode root = new TreeNode(nums[medium]);
        root.left = bfs(nums,left,medium - 1);
        root.right = bfs(nums,medium + 1, right);
        return root;
    }
}
