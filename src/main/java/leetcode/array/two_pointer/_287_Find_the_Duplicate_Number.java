package leetcode.array.two_pointer;

/**
 * Created by lenovo on 2019/5/13.'
 * 找到数组中重读的元素，只有一个元素重复
 */
public class _287_Find_the_Duplicate_Number {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int index = nums[i] > 0 ? nums[i] : -nums[i];
            if(nums[index] > 0)
                nums[index] = -nums[index];
            else
                return index;
        }
        return -1;
    }
}
