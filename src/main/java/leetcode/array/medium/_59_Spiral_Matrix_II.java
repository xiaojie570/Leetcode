package leetcode.array.medium;

/**
 * Created by lenovo on 2019/5/14.
 * 给一个整数，产生一个螺旋顺序矩阵
 * Input: 3
 * Output:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]
 */
public class _59_Spiral_Matrix_II {
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int count = 1;
        int startRow = 0;
        int startCol = 0;
        while(n > 0) {
            if(n == 1) {  // 只有一列的数的时候
                ret[startRow][startCol] = count;
                break;
            }
            for(int i = 0; i < n - 1; i ++) { // 从左到右
                ret[startRow][startCol ++] = count++;
            }
            for(int i = 0; i < n - 1; i ++) { // 从上到下 留下最后一行没有插入数字
                ret[startRow ++][startCol] = count++;

            }
            for(int i = 0; i < n - 1; i ++) {  // 从右到左
                ret[startRow][startCol --] = count ++;
            }
            for(int i = 0; i < n - 1; i++) { // 从下到上
                ret[startRow--][startCol] = count ++;
            }
            startCol ++;
            startRow ++;
            n -= 2;
        }
        return  ret;
    }
}
