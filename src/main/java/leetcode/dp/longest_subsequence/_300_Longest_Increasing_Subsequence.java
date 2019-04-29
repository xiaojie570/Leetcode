package leetcode.dp.longest_subsequence;

import java.util.Arrays;

/**
 * Created by lenovo on 2019/4/29.
 * 最长递增子串的长度，这个子串可以不连续。 时间复杂度是O（n2），
 * 【解题思路】
 *      1. 维护一个一维的dp数组，其中dp[i]表示以nums[i]为结尾的最长递增子串的长度，
 *      2. 对于每一个nums[i]，我们从第一个数搜索到第 i 个数，如果发现某个数小于 nums[i]，我们更新 dp[i]。
 *      3. 更新方法  dp[i]=Math.max(dp[i],dp[j]+1);比较当前dp[i]的值和那个小于num[i]的数的dp值加1的大小
 */
public class _300_Longest_Increasing_Subsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int[] dp=new int[nums.length];
        int max=1;
        for(int i = 0; i < nums.length; i++) {
            dp[i]=1;
            for(int j = 0; j < i; j++) {
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    if(dp[i]>max){
                        max=dp[i];
                    }
                }
            }
        }
        return max;
    }

    // 第二个方法使用了 Arrays.binarySearch 这个方法很巧妙
    public int lengthOfLIS2(int[] nums) {
        final int N = nums.length;
        if (N == 0) {
            return 0;
        }
        int[] dp = new int[N];
        dp[0] = nums[0];
        int len = 1;
        for (int i = 1; i < N; i++) {
            if (nums[i] > dp[len - 1]) {
                dp[len++] = nums[i];
            } else {
                int pos = Arrays.binarySearch(dp, 0, len, nums[i]);
                pos = pos >= 0 ? pos : -(pos + 1);
                dp[pos] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        _300_Longest_Increasing_Subsequence test = new _300_Longest_Increasing_Subsequence();
        int[] nums = {10,9,2,5,3,7,101,18};
        test.lengthOfLIS2(nums);
    }
}
