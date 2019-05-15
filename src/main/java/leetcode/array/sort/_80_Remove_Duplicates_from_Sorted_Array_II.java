package leetcode.array.sort;

/**
 * Created by lenovo on 2019/5/15.
 * 移除给定递增数组中的重复元素，一个元素可以最多重复2次。
 */
public class _80_Remove_Duplicates_from_Sorted_Array_II {
    public int removeDuplicates(int[] nums) {
        if( nums == null || nums.length == 0)
            return 0;
        int ret = 1;
        for(int i = 2; i < nums.length; i++) {
            if(nums[ret - 1] != nums[i]) {  // 这个地方比较的很好，比较的是ret-1和i比较
                ret++;
                nums[ret] = nums[i];
            }
        }
        return ret + 1;
    }

    public static void main(String[] args) {
        _80_Remove_Duplicates_from_Sorted_Array_II test = new _80_Remove_Duplicates_from_Sorted_Array_II();
        int[] nums = {1,1,2,3};
        test.removeDuplicates(nums);
    }
}
