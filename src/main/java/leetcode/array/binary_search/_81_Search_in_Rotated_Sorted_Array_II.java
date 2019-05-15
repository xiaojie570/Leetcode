package leetcode.array.binary_search;

/**
 * Created by lenovo on 2019/5/15.
 * 一个升序数组，在数组的起点和重点有一个断片。且数组中的元素会重复
 */
public class _81_Search_in_Rotated_Sorted_Array_II {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return false;
        int left = 0, right = nums.length - 1;
        int medium = (left + right) / 2;
        while(left <= right) {
            medium = (left + right) / 2;
            if(target == nums[medium])
                return true;
            else if(nums[left] < nums[medium]) {  // 左边小于中间， 左边有序
                if(nums[left] <= target && target < nums[medium]) // 左边小于目标，并且目标小于中间 ——》 想找的元素在左边
                    right = medium - 1;
                else {
                    left = medium + 1;
                }
            }else if(nums[left] > nums[medium]){ // 左边大于中间
                if(nums[medium] < target && target <= nums[right]) // 中间小于目标，右边大于目标 --> 想找的元素在右边
                    left = medium + 1;
                else
                    right = medium - 1;
            }else  // 因为数组中存在重复元素，所以这里需要处理一下相同的元素
                left ++; //处理相同元素
        }
        return false;
    }
}

