package leetcode.array.two_pointer;

/**
 * Created by lenovo on 2019/5/13.
 * 找到数组中长度最小的连续子数组的和大于等于给定的值s的长度
 */
public class _209_Minimum_Size_Subarray_Sum {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0;
        int minLen = nums.length + 1;
        int sum = 0;
        while(right < nums.length && left <= right) {
            sum += nums[right];
            right ++;
            while(left < nums.length && sum >= s) {
                minLen = Math.min(minLen,right - left);
                sum -= nums[left];
                left ++;
            }
        }
        return  minLen != nums.length + 1 ? minLen : 0;
    }
}
