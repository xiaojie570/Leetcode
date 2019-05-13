package leetcode.array.two_dimensional;

/**
 * Created by lenovo on 2019/5/13.
 * 给一个二维数组，如果数组中有元素为0，那么将这个元素对应的行和列的元素都变为 0
 */
public class _73_Set_Matrix_Zeroes {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return;
        boolean firstColZero = false;
        for(int i = 0; i < matrix.length;i++) {  // 先将每一行每一列有0的元素对应的行列的值都变为0
            if(matrix[i][0] == 0)
                firstColZero = true;
            for(int j = 1; j < matrix[0].length;j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length;j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(matrix[0][0] == 0) {
            for(int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0; // 第一行的元素都变为 0
            }
        }
        if(firstColZero) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0; // 第一列的元素都变为0
            }
        }
    }
}
