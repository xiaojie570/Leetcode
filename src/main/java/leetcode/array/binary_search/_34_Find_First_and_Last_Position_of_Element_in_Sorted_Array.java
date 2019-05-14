package leetcode.array.binary_search;

/**
 * Created by lenovo on 2019/5/14.
 * 给定一个递增的数组，数组包含重复元素，给定一个目标数，找到数组中这个数的第一个位置和最后一个位置
 * 【解题思路】
 *      使用二分查找来查找这个数，但是会存在找到的数是在第一个位置和最后一个位置的中间，所以需要在最开始就进行二分查找，找到对应的第一个位置和最后一个位置
 */
public class _34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    int[] nums;
    int target;
    int[] ans;

    public int[] searchRange(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        this.ans = new int[]{-1, -1};
        left(0, nums.length);
        right(0, nums.length);
        return this.ans;
    }

    public void left(int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            if (mid == 0 || nums[mid - 1] != target) {
                ans[0] = mid;
            } else if (nums[mid - 1] == target) {
                left(start, mid);
            }
        } else if (nums[mid] > target) {
            left(start, mid);
        } else if (nums[mid] < target) {
            left(mid + 1, end);
        }
    }

    public void right(int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            if (mid == nums.length - 1 || nums[mid + 1] != target) {
                ans[1] = mid;
            } else if (nums[mid + 1] == target) {
                right(mid + 1, end);
            }
        } else if (nums[mid] > target) {
            right(start, mid);
        } else if (nums[mid] < target) {
            right(mid + 1, end);
        }
    }
}
