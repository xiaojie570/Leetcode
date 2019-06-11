package leetcode.array.easy;

import java.util.Arrays;

/**
 * Created by lenovo on 2019/4/13.
 * 一个数组有2n integers， 需要我们把这个数组分成n对，然后从每一对里面拿小的那个数字，把所有的加起来，返回这个sum。并且要使这个sum 尽量最大。
 * 【解题思路】
 *      如何让sum 最大化呢，我们想一下，如果是两个数字，一个很小，一个很大，
 *      这样的话，取一个小的数字，就浪费了那个大的数字。所以我们要使每一对的两个数字尽可能接近。
 *      我们先把nums sort 一下，让它从小到大排列，接着每次把index： 0， 2， 4...偶数位的数字加起来就可以了。
 *
 *
 *      CSDN: https://blog.csdn.net/xiaojie_570/article/details/91437486
 */
public class _561_Array_Partition_I {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i += 2)
            sum += nums[i];
        return sum;
    }
}
