package leetcode.dp.medium;

import java.util.Arrays;

/**
 * Created by lenovo on 2019/5/29.
 * 给两个数组，交换数组中最少的元素，使得两个数组中的元素都递增
 */
public class _801_Minimum_Swaps_To_Make_Sequences_Increasing {
    public int minSwap(int[] a, int[] b) {
        int n = a.length;
        int[][] dp = new int[n][2];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        dp[0][0] = 0;  // dp[i][0]表示不交换i，使得[0, i]严格递增的最小swap数
        dp[0][1] = 1;  // dp[i][1]表示交换i，使得[0, i]严格递增的最小swap数

        for (int i = 1; i < n; ++i) {
            if (a[i - 1] < a[i] && b[i - 1] < b[i]) {
                dp[i][0] = Math.min(dp[i - 1][0], dp[i][0]);
                dp[i][1] = Math.min(1 + dp[i - 1][1], dp[i][1]);
            }

            if (a[i - 1] < b[i] && b[i - 1] < a[i]) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i][0]); // 不交换 i
                dp[i][1] = Math.min(1 + dp[i - 1][0], dp[i][1]); // 交换 i
            }
        }

        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }
}
