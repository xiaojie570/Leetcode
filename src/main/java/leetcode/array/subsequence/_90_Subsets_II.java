package leetcode.array.subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lenovo on 2019/5/13.
 * 找到数组中的所有子数组，数组中的元素可能重复
 * 【解题思路】
 *  采用dfs的方式
 */
public class _90_Subsets_II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<Integer>();
        dfs(nums,ret,temp,0);
        return ret;
    }

    private void dfs(int[] nums, List<List<Integer>> ret, List<Integer> temp, int start) {
        ret.add(new ArrayList<Integer>(temp));
        for(int i = start; i < nums.length;i++) {
            if(i > start && nums[i] == nums[i - 1]) // 如果是重复的元素，就直接继续循环
                continue;
            temp.add(nums[i]);
            dfs(nums,ret,temp,i + 1);
            temp.remove(temp.size() - 1); //把最后一个元素移除
        }
    }
}
