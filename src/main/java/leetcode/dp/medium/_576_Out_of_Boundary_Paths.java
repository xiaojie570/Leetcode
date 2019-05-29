package leetcode.dp.medium;

import java.util.Arrays;

/**
 * Created by lenovo on 2019/5/29.
 * 在二维数组中，某个位置放一个足球，每次可以在上下左右四个方向中任意移动一步，一共可以移动N步，问共有多少种移动方法可以把足球移除边界
 * 因为结果可能是一个巨大的数，所以让我们对一个大数 109 + 7 取余。
 */
public class _576_Out_of_Boundary_Paths {
    int[][][] mem = null;

    public int findPaths(int m, int n, int N, int i, int j) {  // m * n 维数组，走 N 步， 球的起始位置在 (i,j)
        int MOD = 1000000007;
        if(i<0 || i>=m || j<0 || j>=n) return 0;
        if(N == 0) return 0;

        if(mem == null) {
            mem = new int[m][n][N+1];  // 存储位置和走了多少步
            for(int[][] arr: mem) {  // 首先将数组中的每个元素都置为 -1
                for(int[] ar: arr) {
                    Arrays.fill(ar, -1);
                }
            }
        }

        if(mem[i][j][N] != -1) return mem[i][j][N];

        long num = 0;
        if(i-1<0) {  // 当前元素的左边是边界
            num += 1;
        } else {
            num += findPaths(m, n, N - 1, i-1, j);
            num %= MOD;

        }

        if(i+1>=m) {  // 当前元素的右边是边界
            num += 1;
        } else {
            num += findPaths(m, n, N - 1, i+1, j);
            num %= MOD;
        }

        if(j-1<0) { // 当前元素的上边的边界
            num += 1;
        } else {
            num += findPaths(m, n, N - 1, i, j-1);
            num %= MOD;
        }

        if(j+1>=n) {  // 当前元素的下边是边界
            num += 1;
        } else {
            num += findPaths(m, n, N - 1, i, j+1);
            num %= MOD;
        }

        mem[i][j][N] = (int)num % MOD;

        return (int)num % MOD;
    }
}
