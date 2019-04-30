package leetcode.dp.medium;

/**
 * Created by lenovo on 2019/4/30.
 * 从字符串集合中尽可能多的选出字符串并保证 0 和 1的个数不超过给定的值，题目难度是 medium
 * 【解题思路】
 *      1. 用dp[i][j] 表示前i个字符串在0个数不超过 i，1 的个数不超过k时最多能够选取的字符串的个数。
 *      2. 统计第 i 个字符串中 0 和 1 的个数分别为 c0 和 c1，如果取第 i 个字符串 则 dp[i][j] = Math.max(dp[i][j],dp[i - c0][j - c1] + 1);
 *      3. 其实就是一个取还是不取的问题
 */
public class _474_Ones_and_Zeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int [][] dp = new int[m + 1][n + 1];
        int c0 = 0, c1 = 0;
        for(String str: strs) {
            c0 = 0; c1 = 0;
            for(char c: str.toCharArray()) {
                if(c == '0')  c0 ++;
                else c1 ++;
            }
            for(int i = m; i >= c0; i--) {
                for(int j = n; j >= c1; j--) {
                    dp[i][j] = Math.max(dp[i][j],dp[i - c0][j - c1] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
