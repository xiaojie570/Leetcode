package leetcode.dp.sum;

/**
 * Created by lenovo on 2019/4/29.
 * 题目要求：想要知道n个数分成k组，各组平均数之和的最大值。
 * 【解题思路】
 *      就是看 前 I 个数分成 k-1 组 + 剩余 N-I 个数分成一组，然后平均数之和的最大值。
 *
 */
public class _813_Largest_Sum_of_Averages {
    double ret[][];
    public double largestSumOfAverages(int[] A, int K) {
        ret  = new double[A.length + 1][K + 1];
        double sum = 0;
        for(int i = 0; i < A.length;i ++) {
            sum += A[i];
            ret[i + 1][1] = sum / (i + 1); // 从头到后计算没加入一个元素的平均数
        }
        return help(A.length,K,A);
    }

    private double help(int length, int k, int[] a) {
        if(ret[length][k] > 0) return ret[length][k];
        double cur = 0;
        for(int i = length - 1; i > 0; i--) {
            cur += a[i];
            ret[length][k] =  Math.max(ret[length][k], help(i,k - 1,a) + cur / (length - i)); // 后面的length - i 个数 + 前面的 n-i个数
        }
        return ret[length][k];
    }
}
