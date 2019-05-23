package leetcode.array.medium;

/**
 * Created by lenovo on 2019/5/23.
 * 转置，不适用额外的空间
 * 【解题思路】
 *      1. 先按照副对角线将元素兑换
 *      2. 再按照x中轴线将元素兑换
 */
public class _48_Rotate_Image {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length - i; j++) {
                swap(matrix,i,j);
            }
        }
        for(int i = 0; i < length / 2; i++)
            for(int j = 0; j < length; j++ ) {
                swap2(matrix,i,j);
            }
    }

    private void swap2(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[matrix.length - 1 - i][j];
        matrix[matrix.length - 1 - i][j] = temp;
    }

    private void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[matrix.length - j - 1][matrix.length - i - 1];
        matrix[matrix.length - j - 1][matrix.length - i - 1] = temp;
    }

}
