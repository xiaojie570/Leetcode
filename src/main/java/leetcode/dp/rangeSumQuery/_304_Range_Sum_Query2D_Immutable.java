package leetcode.dp.rangeSumQuery;

/**
 * Created by lenovo on 2019/4/14.
 * 求解一个二维区域和的检索，建立一个累积区域和的数组，然后根据边界值的加减法来快速求出给定区域的和。
 */
public class _304_Range_Sum_Query2D_Immutable {
    int sum2Origin[][] = null;
    public _304_Range_Sum_Query2D_Immutable(int[][] matrix) {
        if (matrix == null || matrix.length <= 0)
            return;
        sum2Origin = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; i ++)
            for (int j = 1; j <= matrix[0].length; j ++)
                sum2Origin[i][j] = sum2Origin[i][j - 1] + sum2Origin[i - 1][j] - sum2Origin[i - 1][j - 1] + matrix[i - 1][j - 1];
        return;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (sum2Origin == null)
            return 0;
        return sum2Origin[row2 + 1][col2 + 1] - sum2Origin[row2 + 1][col1] - sum2Origin[row1][col2 + 1] + sum2Origin[row1][col1];
    }
}
