package leetcode.array.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2019/4/29.
 * Input:
 *      k = 3, n = 7
 * Output:
 *      [[1,2,4]]
 * K 是可以使用的元素的个数，k个元素之和应该为n， 默认可以使用的元素是 【1-9】
 *
 * 【解题思路】
 *      返回的条件要注意一下，是和等于要求的目标和 && 元素的个数等于目标的个数 两个条件才可以
 */
public class _216_Combination_Sum_III {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(n < 0 || k <= 0) return ret;
        List<Integer> sub = new ArrayList<Integer>();
        int num = 1;
        help(k,num,n,ret,sub);
        return ret;
    }

    private void help(int k, int num,int n, List<List<Integer>> ret, List<Integer> sub) {
        if(n < 0)
            return;
        if(n == 0 && k == sub.size()) {
            ret.add(new ArrayList<Integer>(sub));
            return;
        }
        for(int i = num; i < 10; i++) {
            if(n < i) return;
            sub.add(i);
            help(k,i + 1,n - i,ret,sub);
            sub.remove(sub.size() - 1);
        }
    }
}
