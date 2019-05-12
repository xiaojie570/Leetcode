package leetcode.array.two_pointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lenovo on 2019/5/12.
 * 寻找数组中差为k 的数对的个数。
 * 【解题思路】
 *      1. 首先将数组进行排序，然后如果数组元素相等，则进行下一次遍历
 *      2. 如果不相等，则二分查找看是否在他后面的元素中是否有符合条件的元素，如果有则将返回的数对数 +1
 */
public class _532_k_diff_paird_in_an_Array {
    public int findPairs(int[] nums, int k) {
        if(nums == null ||  nums.length == 0 || k < 0)
            return 0;
        Arrays.sort(nums);
        int ret = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            if(Arrays.binarySearch(nums,i + 1,nums.length, nums[i] + k) >= 0)
                ret ++;
        }
        return ret;
    }

    public static void main(String[] args) {
        _532_k_diff_paird_in_an_Array test = new _532_k_diff_paird_in_an_Array();
        int [] a = {1,3,1,5};
        test.findPairs(a,0);
    }
}
