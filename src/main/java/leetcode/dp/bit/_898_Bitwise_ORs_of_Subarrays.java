package leetcode.dp.bit;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lenovo on 2019/5/27.
 * 给定一个正整数数组，求其中（连续）子序列的  【或】 总共有多少种可能取值
 * 【解题思路】
 *      1. 定义三个Set， 一个是返回值，令两个是用来存储遍历过程中的值。
 *      2. 每遍历数组中的一个值就将其放到set中，然后让他与原来的元素进行【或】
 */
public class _898_Bitwise_ORs_of_Subarrays {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> ret = new HashSet<Integer>();
        Set<Integer> cur = new HashSet<Integer>();
        Set<Integer> cur2 = new HashSet<Integer>();
        for(int a : A) {
            cur2 = new HashSet<Integer>();
            cur2.add(a);
            for(int j: cur)
                cur2.add(j | a);
            ret.addAll(cur = cur2);
        }
        return ret.size();
    }
}
