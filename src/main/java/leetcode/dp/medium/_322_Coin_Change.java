package leetcode.dp.medium;

import java.util.Arrays;

/**
 * Created by lenovo on 2019/5/6.
 */
public class _322_Coin_Change {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0)
            return 0;
        int[] dp = new int[amount + 1]; // dp 存储的是金额为 i 需要的钱币个数
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int j = 0; j < coins.length; j++)
            for (int i = coins[j]; i <= amount; i++)
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
