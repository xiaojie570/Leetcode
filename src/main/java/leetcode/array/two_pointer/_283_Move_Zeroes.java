package leetcode.array.two_pointer;

/**
 * Created by lenovo on 2019/5/6.
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 把字符数组中所有0元素都放到数组中的最后。
 * 【解题思路】
 *      不需要使用额外的空间，只需要使用2个指针即可。
 */
public class _283_Move_Zeroes {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        int j = 0;
        for(int i = 0 ; i < nums.length; i++) {
            if(nums[i] != 0)
                nums[j ++] = nums[i];
        }
        for(;j < nums.length; j++)
            nums[j] = 0;
        return;
    }
}
