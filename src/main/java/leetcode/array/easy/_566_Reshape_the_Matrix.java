package leetcode.array.easy;

/**
 * Created by lenovo on 2019/4/23.
 * 将给定的二维数组编程行数为 r，列数为 c 的二维数组
 */
public class _566_Reshape_the_Matrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int x = nums.length, y = nums[0].length;
        int[][] ret = new int[r][c];
        int[] temp = new int[x * y];
        int index = 0;
        if(x * y == r * c) {
            for(int i = 0; i < x; i++) {
                for(int j = 0; j < y; j++) {
                    temp[index ++] = nums[i][j];
                }
            }
            index = 0;
            for(int i = 0; i < r; i ++) {
                for(int j = 0; j < c; j ++) {
                    ret[i][j] = temp[index ++];
                }
            }
            return ret;
        } else
            return nums;
    }
}
