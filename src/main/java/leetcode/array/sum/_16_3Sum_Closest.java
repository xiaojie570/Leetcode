package leetcode.array.sum;

import java.lang.reflect.Array;
import java.util.Arrays;
/**
 * Created by lenovo on 2019/5/23.
 * 给定一个整形数组，找到数组中的三个数，使得他们的和最接近target
 * 【解题思路】
 *      1. 先给数组进行排序（因为找的元素不是连续的元素，所以先排序）
 *      2. 先计算第一个元素 + 第二个元素 + 最后一个元素 作为当前的和，然后不断更新这个值
 *      3. 如果这个值比目标值大，就让 right -- 。如果比目标值小，就让 left ++;
 */
public class _16_3Sum_Closest {
    public int threeSumClosest(int[] nums, int target) {
        int sum = nums[0] + nums[1] + nums[nums.length - 1];
        int min = sum - target;
        Arrays.sort(nums);
        for(int left = 0; left < nums.length; left ++) {
            int right = nums.length - 1;
            int medium = left + 1;
            while(medium < right) {
                sum = nums[left] + nums[medium] + nums[right];
                if(Math.abs(sum - target) < Math.abs(min)) {
                    min = sum - target;
                }
                if(sum == target)
                    return sum;
                else if(sum < target)
                    medium ++;
                else
                    right --;
            }
        }
        return min + target;
    }
}
