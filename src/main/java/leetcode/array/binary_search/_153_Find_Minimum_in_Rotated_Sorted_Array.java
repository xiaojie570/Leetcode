package leetcode.array.binary_search;

/**
 * Created by lenovo on 2019/5/15.
 * 在有反转的数组中找到最小的元素
 */
public class _153_Find_Minimum_in_Rotated_Sorted_Array {
    public int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        return search(nums, 0 , nums.length - 1);
    }

    public int search(int[] nums, int start, int end){
        if(start == end){
            return nums[start];
        }
        else{
            int mid = (start + end) / 2;
            if(mid == start){
                return Math.min(nums[start], nums[end]);
            }
            else{
                if(nums[mid - 1] > nums[mid] && nums[mid] < nums[mid+1]){ // 如果当前的值是尖峰值，比他前面的元素小，比它后边的元素小
                    return nums[mid];  // 那么它应该是最小的值
                }
                else{
                    if(nums[start] > nums[mid]){ // 如果左边的元素大于中间的元素，说明左边有反转的元素
                        return search(nums, start, mid-1);
                    }
                    else if(nums[mid] > nums[end]){ // 如果有变的元素小于中间的元素，说明有变有反转的元素
                        return search(nums, mid+1, end);
                    }
                    else{
                        return nums[start]; // 否则应该是第一个元素就是最小的元素，数组没有反转
                    }
                }
            }
        }
    }
}
