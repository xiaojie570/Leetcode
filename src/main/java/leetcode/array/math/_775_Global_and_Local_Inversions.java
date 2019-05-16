package leetcode.array.math;

/**
 * Created by lenovo on 2019/5/16.
 * 数组A是 [0,1,...,N - 1]的一种排列，N是数组的长度。
 * 全局倒置指的是 i，j 满足 0 <= i < j < N, 并且A[i] > A[j]
 * 局部倒置指的是 i 满足 0 <= i < N 并且 A[i] > A[i+1]
 * 当数组 A 中全局倒置的数量等于局部倒置的数量时，返回 true 。
 *
 *  【解题思路】
 *      1. 局部导致属于全局倒置
 *      2. 存在非局部导致的全局倒置时返回false（即间隔至少一位元素的时候）
 *      3. 数组正常应该是一个连续递增的数组，然后反转了一次。
 *
 */
public class _775_Global_and_Local_Inversions {
    public boolean isIdealPermutation(int[] A) {
        for(int i = 0; i < A.length; i++) {
            if(A[i] - i > 1 || A[i] - i < -1)
                return false;
        }
        return true;
    }
}
