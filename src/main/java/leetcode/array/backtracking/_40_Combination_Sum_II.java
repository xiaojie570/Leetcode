package leetcode.array.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * Created by lenovo on 2019/4/29.
 * 一个数组和一个target。要求从数组中找到所有的组合，它的和是等于target的,元素不允许重复。
 */
public class _40_Combination_Sum_II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0 || target < 0) return res;
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates); //排序，使得寻找相同出权值的节点变得容易
        get(candidates, target, 0, list, res);
        return res;
    }

    private void get(int[] candidates, int target, int i, List<Integer> list, List<List<Integer>> res) {
        if (i > candidates.length || target < 0) return; //因为没有自环，所以每次都是从下一个节点开始搜索，要添加一个条件判断节点仍在图中
        if (target == 0) { //满足条件，添加至结果集
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int p = i; p < candidates.length; p++) {
            if(target < candidates[p])  // 剪枝法
                break;
            list.add(candidates[p]); //添加节点到路径
            get(candidates, target - candidates[p], p+1, list, res); //因为没有自环，所以每次搜索更新路径权值后的下一个节点
            list.remove(list.size()-1); //回溯，将当前节点从路径中剔除
            while (p < candidates.length - 1 && candidates[p] == candidates[p+1]) p++; //因为存在重复节点，所以已经被剔除的节点不能再被放回到路径中
        }
    }
}
