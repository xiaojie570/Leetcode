package leetcode.string.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lenovo on 2019/5/8.
 * 找到给定的数组中缺少的元素。
 * 【解题思路】
 *      给定一个数组，长度就是数组的长度，数组中的值应该是从 1 - （数组长度 - 1） 的值，但是给定的数组中有些元素出现了一次，有些元素出现了多次，
 *      这就导致有些元素没有出现，那么找出数组中缺少的元素。
 *
 *      遍历数组中的元素，将对应的元素对应到下标上，将对应下标的元素 如果元素本身是负的就不变，如果是正的就变为负数。
 *      这样遍历结束后，数组中的元素为正的的下标就是缺少的元素
 */
public class _448_Find_All_Numbers_Disappeared_in_an_Array {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            nums[index] = nums[index] > 0 ? -nums[index] : nums[index];
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0)
                list.add(i + 1);
        }
        return list;
    }
}
