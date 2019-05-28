package leetcode.dp.medium;

import java.util.Arrays;

/**
 * Created by lenovo on 2019/5/28.
 * 返回能够组成目标值的元素的种类
 * nums = [1, 2, 3]
 * target = 4
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * 【解题思路】
 *      这个题的解题思路有点像爬梯子的那个题的思路。
 *      1. 我们需要一个一维数组 dp，其中dp[i]表示目标数为 i 的解的个数，然后从1开始遍历到 target，对于每一个数i，遍历数组 nums，
 *      如果 i >= num， dp[i] += dp[i - num]。 这个也好理解，如对于[1,2,3]，target = 4这个例子，当我们在计算 dp[3]的时候， 3 可以拆分成 2 + num,
 *      此时 num 为 dp[1]，3同样可以拆分成 3 + num, 这个时候  num 为 dp[0]。 我们把所有的情况加起来就是组成3的所有情况。

 */
public class _377_Combination_Sum_IV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num: nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
