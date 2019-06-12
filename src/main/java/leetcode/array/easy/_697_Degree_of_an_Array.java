package leetcode.array.easy;

/**
 * Created by lenovo on 2019/5/27.
 *
 * 【阿里笔试】
 * degree为一个数组中的元素出现频率最大值。要求寻找这个数组中出现频率最大的元素的最小距离。
 *
 * CSDN: https://blog.csdn.net/xiaojie_570/article/details/91500172
 */
public class _697_Degree_of_an_Array {
    public int findShortestSubArray(int[] nums) {
        int[] head = new int[50001];
        int[] degree = new int[50001];  // degree存储的是这个元素出现的频率

        for(int i = 0; i < 50000; i++)
            head[i] = -1;  // 先定义一个head数组，赋初始值 -1

        int  min = nums.length, max = 1;
        for(int i = 0; i < nums.length; i++) {
            if(head[nums[i]] == -1)  // 说明之前还没有元素
                head[nums[i]] = i;  // head存储这个元素对应的下标位置，head的下标是每个元素nums[i]
            degree[nums[i]] ++;  // degree存储的是这个元素出现的频率
            if(degree[nums[i]] > max) {
                max = degree[nums[i]];
                min = i - head[nums[i]] + 1;
            } else if(degree[nums[i]] == max && min > i - head[nums[i]] + 1)
                min = i - head[nums[i]] + 1;
        }
        return min;
    }
}
