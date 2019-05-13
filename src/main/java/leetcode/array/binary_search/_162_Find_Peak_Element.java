package leetcode.array.binary_search;

/**
 * Created by lenovo on 2019/5/13.
 * 找到数组中的尖峰元素，数组中的尖峰元素有很多，只需要返回一个就可以。
 * 【解题思路】
 *      1. 使用二分法去查找就可以了。
 */
public class _162_Find_Peak_Element {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
        while(start < end) {
            int mid = (start + end) / 2;
            if(nums[mid] > nums[mid + 1])
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }
}
