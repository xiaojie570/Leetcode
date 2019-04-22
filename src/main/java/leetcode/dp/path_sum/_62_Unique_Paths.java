package leetcode.dp.path_sum;

/**
 * Created by lenovo on 2019/4/22.
 * 机器人走路，只能往下走或者往右走。问有多少种走法
 */
public class _62_Unique_Paths {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i = 0 ; i < m; i++)
            dp[i][0] = 1; // 每一行的第一列
        for(int i = 0; i < n; i++)
            dp[0][i] = 1; // 第一行
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j ++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {

    }
}
