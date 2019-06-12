package leetcode.array.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lenovo on 2019/5/7.
 * 给定两个数组，交换两个数组中的一个数，使得两个数组中的和相等
 * 【解题思路】
 *      1. 首先分别计算出A和B数组的和，然后计算平均值 avg, 平均值就是A和B交换后数组中的和
 *      2. 然后依次遍历数组A，遍历到第 i 个数，如果把A[i]换掉，那么A中剩余元素的和是：sumA - A[i]。要想使A的各元素和达到avg，还差avg - (sumA - A[i])
 *
 *      CSDN: https://blog.csdn.net/xiaojie_570/article/details/91641877
 */
public class _888_Fair_Candy_Swap {
    public int[] fairCandySwap(int[] A, int[] B) {
        Set<Integer> hashSet = new HashSet<Integer>();
        int sumA = 0, sumB = 0;
        int avg = 0;
        int[] ret = new int[2];
        for(int a: A) sumA += a;
        for(int b: B) {
            sumB += b;
            hashSet.add(b);
        }
        avg = (sumA + sumB) / 2;
        for(int a : A) {
            if((hashSet.contains(-(sumA - a - avg)))) {
                ret[0] = a;
                ret[1] = -(sumA - a - avg);
                return ret;
            }
        }
        return null;
    }
}
