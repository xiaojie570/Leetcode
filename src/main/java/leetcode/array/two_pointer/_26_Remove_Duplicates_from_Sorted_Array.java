package leetcode.array.two_pointer;

/**
 * Created by lenovo on 2019/5/10.
 * 移除数组中重复的元素，移除之后返回新数组的长度
 * 【解题思路】
 *      使用双指针。这个题很典型。
 */
public class _26_Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        int j = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1]) {
                nums[j ++] = nums[i];
            }
        }
        return j;
    }
}
