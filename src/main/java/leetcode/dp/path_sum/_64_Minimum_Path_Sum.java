package leetcode.dp.path_sum;

/**
 * Created by lenovo on 2019/4/27.
 * 从左上为起点，走到右下为终点的路径，前进方向只能向下或者向右，求一条经过元素和最小的路径和
 */
public class _64_Minimum_Path_Sum {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid[0].length == 0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[] dp = new int[cols];
        for(int i = 0; i < cols;i++)
            dp[i] = grid[0][i] + (i == 0 ? 0 : dp[i - 1]);
        for(int i = 1; i < rows;i ++) {
            dp[0] = grid[i][0] + dp[0];
            for(int j = 1 ; j < cols; j++) {
                dp[j] = grid[i][j] + Math.min(dp[j - 1], dp[j]);
            }
        }
        return dp[cols - 1];
    }
}
