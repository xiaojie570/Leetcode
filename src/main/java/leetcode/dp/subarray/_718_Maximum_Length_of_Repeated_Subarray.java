package leetcode.dp.subarray;

/**
 * Created by lenovo on 2019/4/27.
 * 给定两个数组，返回这两个数组最长重复子串的长度
 * 【解题思路】
 *  1. 数组A从前往后遍历，数组B从后往前遍历，如果能够匹配就更改dp对应B下标的值
 */
public class _718_Maximum_Length_of_Repeated_Subarray {
    public int findLength(int[] A, int[] B) {
        int Alength = A.length, Blength = B.length;
        int[] dp = new int[Alength + 1];
        int max = 0;
        for(int i = 1; i <= Alength; i++) {
            for(int j = Blength; j > 0; j--) {
                max = Math.max(max,dp[j] = A[i- 1] == B[j - 1] ? dp[j - 1] + 1: 0);
            }
        }
        return max;
    }
}
