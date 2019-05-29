package leetcode.dp.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by lenovo on 2019/5/28.
 * 给一个 N*N 的国际象棋棋盘，上面有一个骑士，相当于马，只能走'日'，给我们一个起始位置，然后允许我们可以走 K步，
 * 问走完K步之后，还能留在棋盘上的概率是多少？
 * 我们可以不需要关心骑士的起始位置，而是把棋盘上所有位置上经过K步还留在棋盘上的走法总和都算出来，然后直接返回需要的值即可。
 */
public class _688_Knight_Probability_in_Chessboard {
    int[][] moves = {{1,2},{1,-2},{-1,2},{-1,-2},{2,-1},{2,1},{-2,-1},{-2,1}};
    public double knightProbability(int N, int K, int r, int c) {
        double[][][] dp = new double[K+1][N][N];  // 这里需要三维数组，第一维 表示走多少步，第二位表示横坐标，第三位表示纵坐标
        return helper(dp, N, K, r, c) / Math.pow(8.0, K);
    }
    private double helper(double[][][] dp, int N, int k, int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= N) return 0.0;
        if (k == 0) return 1.0;
        if (dp[k][r][c] != 0.0) return dp[k][r][c];  // 如果没有超过界限，就将它返回即可。
        for (int i = 0; i < 8; i++) // 一共有 8 种走法
            dp[k][r][c] += helper(dp, N, k-1, r+moves[i][0], c+moves[i][1]);
        return dp[k][r][c];
    }


}
