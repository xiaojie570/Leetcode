package leetcode.array.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lenovo on 2019/4/29.
 * 一个数组和一个target。要求从数组中找到所有的组合，它的和是等于target的。
 * 任何组合只要是它的和等于target，都需要找到，但是不需要重复的。
 * 【解题思路】
 *      1. 这个题允许我们重复使用同一个数字，所以，我们每次都带入同一数字，直到和等于target或者它超过了target然后再倒退回去一个数字，继续找下一个数字。
 *      2. 使用backtracking：每次倒退回一个数字，需要继续递归下去，再倒退，一直重复到搜索了所有的可能性。
 */
public class _39_Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(target < 0 || candidates == null || candidates.length == 0)
            return ret;
        Arrays.sort(candidates);
        List<Integer> sub = new ArrayList<Integer>();
        help(candidates,target,0,sub,ret);
        return ret;
    }

    private void help(int[] candidates, int target, int i, List<Integer> sub, List<List<Integer>> ret) {
        if(target == 0) {
            ret.add(new ArrayList<Integer>(sub));
            return;
        }
        for(int index = i; i <candidates.length; i++) {
            if(i != 0 && candidates[i] == candidates[i - 1])
                continue;
            if(target < candidates[i])
                break;

            sub.add(candidates[i]);

            help(candidates,target - candidates[i],i,sub,ret);
            sub.remove(sub.size() - 1);
        }
    }
}
