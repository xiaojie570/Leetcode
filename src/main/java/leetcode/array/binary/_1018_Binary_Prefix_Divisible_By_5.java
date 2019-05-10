package leetcode.array.binary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2019/5/10.
 * 给定一个数组，数组中的元素是二进制，定义：Ni： 从A[0]到A[i] 的第i个子数组被解释为一个二进制数（从高位到地位的有效位）。
 * 返回boolean列表，只有当Ni可以被5整除的时候，答案为true。否则为false
 */
public class _1018_Binary_Prefix_Divisible_By_5 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ret = new ArrayList<Boolean>();
        int sum = 0;
        for(int num : A) {
            sum = ((sum << 1) + num) % 5;
            if(sum % 5 == 0)
                ret.add(true);
            else
                ret.add(false);
        }
        return ret;
    }
}
