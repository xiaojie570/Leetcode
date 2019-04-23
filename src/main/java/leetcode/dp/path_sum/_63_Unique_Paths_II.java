package leetcode.dp.path_sum;

import java.util.HashMap;

/**
 * Created by lenovo on 2019/4/22.
 * 带障碍的机器人走路，只能往下或者往右走
 */
public class _63_Unique_Paths_II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length+1][obstacleGrid[0].length+1];
        dp[1][1] = obstacleGrid[0][0] != 1 ?  1 : 0;
        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                dp[i][j] +=  obstacleGrid[i-1][j-1] != 1 ? dp[i][j-1] +
                        dp[i-1][j] : 0;
            }
        }
        return dp[obstacleGrid.length][obstacleGrid[0].length];
    }
}
