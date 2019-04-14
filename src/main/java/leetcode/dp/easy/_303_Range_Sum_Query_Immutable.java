package leetcode.dp.easy;

/**
 * Created by lenovo on 2019/4/14.
 * 给定数组 [-2,0,3,-5,2,-1]，求指定下标i到下标j的数组元素和。
 * 【解题思路】
 *      1. 定义一个长度为给定数组长度+1的数组，这个数组的第一个元素为0，其余各个位置的元素为当前nums元素到前面的所有元素和
 *      2. 找到指定范围的元素和就是 j+1 位置的元素 -i位置的元素
 */
public class _303_Range_Sum_Query_Immutable {
    int[] prefixSum;
    public _303_Range_Sum_Query_Immutable(int[] nums) {
        prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for(int i = 0; i < nums.length; i++)
            prefixSum[i + 1] = nums[i] + prefixSum[i];
    }

    public int sumRange(int i, int j) {
        return prefixSum[j + 1] - prefixSum[i];
    }
}
