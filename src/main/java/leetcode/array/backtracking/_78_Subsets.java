package leetcode.array.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2019/5/6.
 * 给定一个数组，返回这个数组可以组成的所有组合
 */
public class _78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ret.add(new ArrayList<Integer>());
        for(int num: nums) {
            int size = ret.size();
            for(int i = 0; i < size; i++) {
                List<Integer> temp = new ArrayList<Integer>(ret.get(i));
                temp.add(num);
                ret.add(temp);
            }
        }
        return ret;
    }
}
