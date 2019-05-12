package leetcode.array.medium;

import java.util.Arrays;

/**
 * Created by lenovo on 2019/5/12.
 * 给定一个数组，返回一个数组，返回的数组的每一个元素值等于所有元素值的乘积，除了当前元素自己
 * 【解题思路】
 *      当前元素的左右元素乘积。相当于二分法的思路，否则容易超时。
 */
public class _238_Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int product = 1;
        int[] ret = new int[length];
        Arrays.fill(ret,1);
        for(int i = 1; i < nums.length; i++) {
            product = product * nums[i - 1]; // 当前元素的左边元素的乘积
            ret[i] =  product;
        }
        product = 1;
        for(int j = length - 2; j >= 0; j --) { // 从右边的倒数第二个开始，因为最后一个的乘积就是上一个循环计算出来的，最后一个元素没有右边的元素了
            product = product * nums[j + 1]; // 当前元素的右边的元素的乘积
            ret[j] *= product;
        }
        return ret;
    }
}
