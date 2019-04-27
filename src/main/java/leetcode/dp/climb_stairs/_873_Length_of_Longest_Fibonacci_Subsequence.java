package leetcode.dp.climb_stairs;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lenovo on 2019/4/27.
 * 给定一个严格单调递增的数据，求数组中最多有多少个数满足斐波那契数列
 * 【解题思路】
 *  1. 将给定的数组放到HashSet中
 *  2. 最开始的两个数确定了，后续就确定了，直接暴力放到set里面，然后两个数的和看是否在set中即可。
 */
public class _873_Length_of_Longest_Fibonacci_Subsequence {
    public int lenLongestFibSubseq(int[] A) {
        Set<Integer> hashSet = new HashSet<Integer>();
        int max = 2;
        for(int i: A)
            hashSet.add(i);
        for(int i = 0; i < A.length - 1; i++) {
            for(int j = i + 1; j <A.length; j++) {
                int a = A[i],b = A[j];
                int curMax = 2;
                while(hashSet.contains(a + b)) {
                    curMax++;
                    int temp = a;
                    a = b;
                    b = temp + b;
                }
                max = Math.max(curMax,max);
            }
        }
        return max == 2 ? 0:max;
    }
}
