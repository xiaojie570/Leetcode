package leetcode.array.two_pointer;

import java.util.Arrays;

/**
 * Created by lenovo on 2019/5/9.
 * 移除数组中的给定元素，返回移除后的数组的长度
 * 【解题思路】
 *      两个方法，都可以，第二个方法的代码少一些。第一个方法使用的是2个指针的方法
 */
public class _27_Remove_Element {
    public int removeElement(int[] nums, int val) {
        int start = 0, end = nums.length - 1;
        while(start < end) {
            while(start < nums.length && nums[start] != val) start ++;
            while(end >= 0 && nums[end] == val) end --;
            if(start < end && start < nums.length && end >= 0) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start ++;
                end --;
            }
        }
        int count = 0;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] == val)
                count ++;
        }
        return nums.length - count;
    }
}
class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[left] = nums[i];
                left++;
            }
        }
        return left;
    }
}
