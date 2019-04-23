package leetcode.array.easy;

/**
 * Created by lenovo on 2019/4/23.
 * 给二维数组转置
 */
public class _867_Transpose_Matrix {
    public int[][] transpose(int[][] A) {
        int length = A.length;
        int [][] ret = new int[A[0].length][length];
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                ret[j][i] = A[i][j];
            }
        }
        return ret;
    }
}
