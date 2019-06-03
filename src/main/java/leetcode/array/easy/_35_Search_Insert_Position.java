package leetcode.array.easy;

/**
 * Created by lenovo on 2019/5/9.
 * 找到要插入元素的位置。
 * 给定一个有序数组，和一个元素target，找到这个元素target应该插入到数组中的下标位置，如果数组中已经有该元素，那么直接返回这个元素的下标。
 *
 * CSDN: https://blog.csdn.net/xiaojie_570/article/details/90759819
 */
public class _35_Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return 0;
        int i = 0;
        for(i = 0; i < nums.length; i++) {
            if(nums[i] >= target)
                return i;
        }
        if(i == nums.length)
            return nums.length;
        return 0;
    }
}
