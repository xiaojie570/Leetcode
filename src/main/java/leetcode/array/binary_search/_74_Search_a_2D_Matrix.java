package leetcode.array.binary_search;

/**
 * Created by lenovo on 2019/5/27.
 * 给定一个矩阵，满足矩阵中每一行都是递增的，而且每一行的第一个值比上一行的最后一个值要大，在这个矩阵中找到一个目标值。
 */
public class _74_Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;
        int i = matrix.length - 1;
        int j = 0;
        while(i >= 0 && j < matrix[0].length) {
            if(target > matrix[i][j]) j ++;
            else  if(target < matrix[i][j])
                i --;
            else
                return true;
        }
        return false;
    }
}
