package leetcode.dp.longest_subsequence;

import java.util.Arrays;

/**
 * Created by lenovo on 2019/4/28.
 * 最长递增子序列的升级版，求最大长度下，总共有多少条路径
 */
public class _673_Number_of_Longest_Increasing_Subsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;


        int len = nums.length;
        // dp[i] means the lengh of LIS ending at i
        int[] dp = new int[len]; // 以i结尾的递增子串的长度
        Arrays.fill(dp, 1);
        // cnt[i] means # LIS ending at i  用cnt[i]表示以nums[i]为结尾的递推序列的个数
        int[] cnt = new int[len];

        int ret = 0, max = 1;
        for (int i = 0; i < len; i++) {
            int count = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (1 + dp[j] > dp[i]) {
                        count = cnt[j];
                        dp[i] = 1 + dp[j];
                    } else if (1 + dp[j] == dp[i]) {
                        count += cnt[j];
                    }
                }
            }
            cnt[i] = count;

            if (dp[i] > max) {
                ret = count; // ret 最长递增子串的个数
                max = dp[i];
            } else if (dp[i] == max) {
                ret += count;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        _673_Number_of_Longest_Increasing_Subsequence test = new _673_Number_of_Longest_Increasing_Subsequence();
        int[] nums = {1,3,5,4,7};
        test.findLengthOfLCIS(nums);
    }
}
