package leetcode.dp.medium;

import java.util.Arrays;

/**
 * Created by lenovo on 2019/4/30.
 * 题意：给定一个正整数n，找出最少的完全平方数使它们的和等于n
 * 【解题思路】
 *      dp[i]表示第 i 个数至少有多少个完全平方数的和组成。
 *      dp[0]=dp[1]=dp[4]=dp[9]=1,因此12-9,等于３，发现３的位置为０，表示还没有计算，因此计算３，３之前只有１是完全平方，所以找3-1＝２的组成，发现２也没计算，所以找２，２之前也只有一个完全平方１，所以２－１＝１，１就是完全平方数，所以可以把2和3的组成找到，即：２＝1+1,3=1+1+1。
 */
public class _279_Perfect_Squares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE); //这一步很重要，因为后面要比较得到最小的值，如果不初始化为最大值，那么最后返回的永远是0
        dp[0] = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j * j <= i;j++) {
                dp[i] = Math.min(dp[i],dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
