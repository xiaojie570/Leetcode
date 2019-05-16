package leetcode.array.medium;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by lenovo on 2019/5/16.
 * 每次移动可以把一个数字增加1，现在要把数组编程没有重复数字的数组，问需要的最少移动是多少？
 * 【解题思路】
 *  1. 先将数组进行排序
 *  2. 用hash存储每个元素，如果这个元素在hash里面存在，那就应该存放到下一个位置。
 */
public class _945_Minimum_Increment_to_Make_Array_Unique {
    public int minIncrementForUnique(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        Arrays.sort(A); // 给数组排序
        int ret = 0;
        int max = -1;
        HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < A.length; i++) {
            if(!hashMap.containsKey(A[i])) {
                hashMap.put(A[i],i);
                max = A[i]; // 当前为止的最大元素
            } else {
                max ++; // 应该放的是哪个元素
                hashMap.put(max,i);
                ret += max - A[i]; // 应该放的元素与当前元素还差多少个1
            }
        }
        return  ret;
    }
}
