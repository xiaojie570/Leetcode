package leetcode.dp.medium;

import java.util.Arrays;

/**
 * Created by lenovo on 2019/5/6.
 * 给一个面值数组，求组成某个金额最少需要多少纸币
 * 最终滚动数组优化的版本.即 使用以为数组
 * 先看看使用二维数组的状况：
 *  用 dp[m][n]来表示所有可能的状态，dp[i][j]表示，用当前 i 个面值，表示总额 j 需要的纸币的最少数目。
 */
public class _322_Coin_Change {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0)
            return 0;
        int[] dp = new int[amount + 1]; // dp 存储的是金额为 i 需要的钱币个数
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int j = 0; j < coins.length; j++) // 循环遍历零钱
            for (int i = coins[j]; i <= amount; i++)  //
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1); // 要获取 i 总额
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
