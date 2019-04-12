package leetcode.array.easy;

import java.util.Arrays;

/**
 * Created by lenovo on 2019/4/12.
 */
public class _977_Squares_of_a_Sorted_Array {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] ret = new int[n];
        int i = 0, j = n - 1,k = n - 1;
        while(i <= j) {
            ret[k --] = A[i] * A[i] >= A[j] * A[j] ? A[i] * A[i ++] : A[j] * A[j--];
        }
        return ret;
    }
}
