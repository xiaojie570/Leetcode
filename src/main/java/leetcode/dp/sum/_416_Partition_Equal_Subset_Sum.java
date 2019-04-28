package leetcode.dp.sum;

/**
 * Created by lenovo on 2019/4/28.\
 * 给定一个数组，问这个数组能不能分成两个子集合，使得子集合的元素之和相同。
 * 【解题思路】
 *      1. 首先原数组的所有数字之和一定是偶数，不然无法茶城两个和相同的子集合。所以我们的target = sum / 2
 *      2. 问题转化为能不能找到一个非空子集合，使得其数字之和为target
 *      3. dp是布尔值， 最后返回dp[target]. 每遍历一个数nums[i]，就更新dp，我们需要想办法用数组中的数字去拼凑 target。
 *          因为都是正数，所以一定会越加越大，所以加上nums[i]之后，相加的和就在区间[nums[i],target]中的某个值，
 *          所以，如果对这个区间的任意一个数字j，如果 dp[j - nums[i]] 为true，就说明现在已经组成了 j - nums[i] 这个数了，再加上nums[i]就可以组成数字j了。
 *          如果之前dp[j]已经为true，那么之后要一直保持true，所以要 “或”自身。
 *      4. 状态转移方程：
 *              dp[j] = dp[j] || dp[j - nums[i]]         (nums[i] <= j <= target)
 *      5. 注意，第二个for循环要从target遍历到nums[i]，不能反过来，因为，如果我们从nums[i]遍历到target的话，如果nums[i] = 1，那么[1,target]中的所有dp值都为true，因为dp[0]=true.
 *
 */
public class _416_Partition_Equal_Subset_Sum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % 2 == 1)
            return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for(int num : nums) {
            for(int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }
}
