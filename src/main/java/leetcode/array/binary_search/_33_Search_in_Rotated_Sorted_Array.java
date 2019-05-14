package leetcode.array.binary_search;

/**
 * Created by lenovo on 2019/5/14.
 * 一个升序数组，在数组的起点和重点有一个断片。
 * 【解题思路】
 *      使用二分查找，但是我们正常在使用二分查找的时候，默认是从起点到终点是一个有序序列。但是在这个题中，我们还想继续二分查找，这个默认条件就不存在了。
 *      不过，旋转有序数组有一个特点，假设本身是个升序序列，从左向右。如果左边的点比右边的点小，说明这两个点之间是有序的，不存在旋转点。
 *      如果左边的点比右边的大，说明这两个点之间有一个旋转点，导致了不再有序。因为只有一个旋转点，所以一分为二后，肯定有一半是有序的。
 *      所以，我们还是可以用二分法，不过要先判断左半边有序还是右半边有序。如果左半边有序，则直接将目标和左半边的边界比较，就知道目标在不在左半边了，
 *      如果不在左半边肯定在右半边。同理，如果右半边有序，则直接将目标和右半边的边界比较，就知道目标在不在右半边了，如果不在右半边肯定在左半边。这样就完成了二分。
 */
public class _33_Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid = (left + right) / 2;
        while(left <= right) {
            mid = (right - left) / 2 + left;
            if(target == nums[mid])
                return mid;
            if(nums[mid] <= nums[right] ){ // 核心就是判断哪边是有序的！！！
                // 右边是有序的
                if(target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else {
                // 右边是无序的，左边是有序的
                if(target < nums[mid] && target >= nums[left])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }
}
