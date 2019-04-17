package leetcode.dp.arithmetic_slices;

/**
 *
 * Created by lenovo on 2019/4/17.
 * 难度【medium】
 * A = [1, 2, 3, 4]
 * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 * 给定一个数组，找到这个数组中能够组成等差数列的连续子数组个数。
 * 【解题思路】
 *      1. 定义一个与给定数组一样长度的记录等差数组元素个数的数组
 *      2. 如果当前数组前面是等差数组就在前面的数组值基础上 + 1.如果不是就设置当前数组个数为 3
 *      3. 最后返回满足条件的数组的个数。
 */
public class _413_Arithmetic_Slices {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length == 0) return 0;
        int[] ret = new int[A.length];
        for(int i = 2; i < A.length; i++) {
            if(A[i]  - A[i - 1] == A[i - 1] - A[i - 2]) {
                if(ret[i - 1] == 0)
                    ret[i] = 3;
                else
                    ret[i] = ret[i - 1] + 1;
            } else
                ret[i] = 0;
        }
        int retSum = 0;
        for(int i : ret) {
            if(i != 0) retSum += i - 3 + 1;
        }
        return retSum;
    }
}
