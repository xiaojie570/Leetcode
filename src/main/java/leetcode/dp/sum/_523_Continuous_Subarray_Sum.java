package leetcode.dp.sum;

import java.util.HashMap;
import java.util.Map;
import java.util.zip.Inflater;

/**
 * Created by lenovo on 2019/4/28.
 * 给定一个非负数组和目标整数K，写一个函数以检测给定数组中是否有一个长度至少为2的连续子序列，使得其和能够被K整除，即其和为 n *K
 * 【解题思路】
 *
 */
public class _523_Continuous_Subarray_Sum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,-1); // 这个初始化是为了如果第二个数就满足了题意，这里可以保证前两个数的长度为2. -> i - temp
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(k != 0) sum %= k;  // 求和的数等于 sum %=k 的目的是存储当前连续的和 余上k 会多出多少值
            Integer temp = map.get(sum);
            if(temp != null) {
                if(i - temp > 1)
                    return true;
            } else
                map.put(sum,i);
        }
        return false;
    }
}
