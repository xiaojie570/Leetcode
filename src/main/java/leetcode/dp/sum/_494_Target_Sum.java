package leetcode.dp.sum;

/**
 * Created by lenovo on 2019/4/28.
 * 给定一个数组，和一个定值，可以给数组的元素加+和-符号，问有多少种不同的添加符号的方法使得数组元素和等于S
 *
 */
public class _494_Target_Sum {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0)
            return 0;
        int sum = 0;
        for(int num : nums) sum += num;
        if((sum + S) % 2 == 1 || sum < S) return 0;
        int target = (sum + S) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int num : nums) {
            for(int i = target; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
}
