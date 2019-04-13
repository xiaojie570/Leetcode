package leetcode.dp.subarray;

/**
 * Created by lenovo on 2019/4/13.
 * 最长湍流子数组。
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
        若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
        或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
        也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
    【解题思路】
        就是比较当前元素和前一个元素的大小，记录这个差值到cur变量中。
        如果cur变量等于0，说明当前元素和前一个元素相等，相等的元素不是湍流元素，所以要将start重置为当前元素下标
        然后用cur与当前元素和后一个元素的差值相乘，如果和小于0才符合湍流素组的概念，
        如果不符合湍流数组的概念就需要更新len的长度，且还要更新start的小标。
 */
public class _978_Longest_Turbulent_Subarray {
    public int maxTurbulenceSize(int[] A) {
        int len = 1, start = 0;
        for(int i = 1; i < A.length; i++) {
            long cur = A[i] - A[i - 1];
            if(cur == 0) start = i;
            else if(i == A.length - 1 || (cur * (A[i + 1] - A[i]) >= 0)) {
                len = Math.max(len, i - start + 1);
                start = i;
            }
        }
        return len;
    }
}
