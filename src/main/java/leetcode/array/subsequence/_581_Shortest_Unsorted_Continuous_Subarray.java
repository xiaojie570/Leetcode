package leetcode.array.subsequence;

/**
 * Created by lenovo on 2019/5/10.
 * 给定一个排序的数组，但是数组中的一些元素顺序乱了，导致数组不是排序数组了，现在想要找到变换最小的连续子元素的长度，使得数组变为有序。
 */
public class _581_Shortest_Unsorted_Continuous_Subarray {
    public int findUnsortedSubarray(int[] nums) {
        int start = 0, end = nums.length;
        int max = nums[0];
        int min = nums[nums.length - 1];
        for(int i = 0; i < nums.length; i++) { // 从前往后找最大值
            if(max > nums[i])
                end = i;
            else
                max = nums[i];
        }
        for(int i=nums.length-1;i>=0;i--){ // 从后往前找最小值
            if(min < nums[i])
                start = i;
            else
                min = nums[i];
        }
        if(end - start == nums.length)
            return 0;
        return end - start + 1;
    }
}
