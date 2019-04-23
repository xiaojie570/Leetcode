package leetcode.array.easy;

/**
 * Created by lenovo on 2019/4/23
 * 二维数组判断斜着的每一列是否相等.
 */
public class _766_Toeplitz_Matrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix == null || matrix[0].length == 0) return true;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                int m = i, n = j, temp = matrix[i][j];
                while(m < matrix.length && n < matrix[0].length) {
                    if(temp != matrix[m][n])
                        return false;
                    else {
                        m ++;
                        n ++;
                    }
                }
            }
        }
        return true;
    }
}
