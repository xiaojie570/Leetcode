package leetcode.array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2019/5/14.
 * 将一个矩阵按螺旋顺序输出。
 */
public class _54_Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return ret;
        int rows = matrix.length, cols = matrix[0].length;
        for(int i = 0; i * 2 < rows && i * 2 < cols; i++) {
            help(matrix, ret, i);
        }
        return ret;
    }

    private void help(int[][] matrix, List<Integer> ret, int start) {
        int rows = matrix.length, cols = matrix[0].length;
        int startRow = start, endRow = rows - start - 1;
        int startCol = start, endCol = cols - start - 1;
        for(int i = startCol; i <= endCol; i++) {  // 从左到右
            ret.add(matrix[startRow][i]);
        }
        if(endRow >= startRow) {
            for(int i = startRow + 1; i <= endRow; i++) { // 从上到下
                ret.add(matrix[i][endCol]);
            }
        }
        if(endRow > startRow && endCol >= startCol) { // 从右到左
            for(int i = endCol - 1; i >= startCol; i--) {
                ret.add(matrix[endRow][i]);
            }
        }
        if(endCol > startCol && endRow >= startRow + 1) { // 从下到上
            for(int i = endRow-1; i >= startRow+1; i--) {
                ret.add(matrix[i][startCol]);
            }
        }
    }
}
