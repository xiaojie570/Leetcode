package leetcode.array.easy;

/**
 * Created by lenovo on 2019/5/27.
 * degree为一个数组中的元素出现频率最大值。要求寻找这个数组中出现频率最大的额元素的最小距离。
 */
public class _697_Degree_of_an_Array {
    public int findShortestSubArray(int[] nums) {
        int[] head = new int[50001];
        int[] degree = new int[50001];

        for(int i = 0; i < 50000; i++)
            head[i] = -1;

        int  min = nums.length, max = 1;
        for(int i = 0; i < nums.length; i++) {
            if(head[nums[i]] == -1)
                head[nums[i]] = i;
            degree[nums[i]] ++;
            if(degree[nums[i]] > max) {
                max = degree[nums[i]];
                min = i - head[nums[i]] + 1;
            } else if(degree[nums[i]] == max && min > i - head[nums[i]] + 1)
                min = i - head[nums[i]] + 1;
        }
        return min;
    }
}
