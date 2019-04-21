package leetcode.dp.math;

/**
 * Created by lenovo on 2019/4/21.
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * 将一个数用比他小的数求和得出来，现在要输出这些比他小的数中乘积最大的值是多少。
 * 【解题思路】 dp
 * 首先要有状态初始的条件。初始的时候，如果n给定的值是2或者3，直接返回对应的值。
 * 如果不是的话，需要进入循环，在转移矩阵中，对应的初始值一定要注意，是2 -> 2, 3 -> 3。
 */
public class _343_Integer_Break {
    public int integerBreak(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        int[] products = new int[n + 1];

        products[2] = 2;
        products[3] = 3;
        // i是你要找的那个数
        for(int i = 4; i <= n; i++) {
            int max = 0;
            // j 是把这个数分成几份
            for(int j = 2; j <= i - j; j++) {
                max = Math.max(max, products[j] * products[i - j]);
            }
            products[i] = max;
        }
        return products[n];
    }
}
