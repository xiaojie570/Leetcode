package leetcode.array.subarray;

/**
 * Created by lenovo on 2019/5/15.
 * 给定的数组是首尾相连的，问数组中连续子数组的最大和是多少。数组是循环的
 * 【解题思路】
 *      1. 如果不跨行，就正常求解最大值
 *      2. 如果跨行，循环过来了，就用 sum-最小的连续子元素的和
 */
public class _918_Maximum_Sum_Circular_Subarray {
    public int maxSubarraySumCircular(int[] A) {
        int l = A.length;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int tot = 0;
        int tot2 = 0;
        int max = Integer.MIN_VALUE;
        for(int i : A) {
            sum+=i; // 得到所有元素的和
            tot += i; // 得到和大于0的连续元素和，如果连续元素的和 < 0 则将这个值变为 0， 记录当前子序列
            min = Math.min(tot,min); // 记录全局子序列
            if(tot > 0) tot = 0; // 得到和小于0的连续元素和，
            tot2 += i;
            max = Math.max(tot2,max);
            if(tot2 < 0) tot2 = 0;
        }
        if(max < 0) return max;
        return Math.max(max,sum-min);
    }

    public static void main(String[] args) {
        _918_Maximum_Sum_Circular_Subarray test = new _918_Maximum_Sum_Circular_Subarray();
        int[] A ={3,-2,2,3};
        test.maxSubarraySumCircular(A);
    }
}
