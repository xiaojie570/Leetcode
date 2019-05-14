package leetcode.array.medium;

import java.util.Arrays;

/**
 * Created by lenovo on 2019/5/13.
 */
public class _16_3Sum_Closest {
    public int threeSumClosest(int[] nums, int target) {
        int ret = Integer.MAX_VALUE;
        Arrays.sort(nums);

        return ret;
    }

    public int help(int[] nums, int begin, int end, int target) {
        int min = Integer.MAX_VALUE;
        int left = begin + 1, right = end;
        while(left < right) {
            if(nums[left] + nums[right] + nums[begin] == target) {
                return 0;
            } else if(nums[left] + nums[right] + nums[begin] < target) {
                if(target - (nums[left] + nums[right] + nums[begin] ) < Math.abs(min))
                    min = target - (nums[left] + nums[right] + nums[begin] );
                left ++;
            } else {
                if((nums[left] + nums[right] + nums[begin] - target) > Math.abs(min))
                    min = nums[left] + nums[right] + nums[begin] - target;
                right --;
            }
        }
        return min;
    }
}
