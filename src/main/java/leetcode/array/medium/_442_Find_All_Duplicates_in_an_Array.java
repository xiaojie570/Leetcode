package leetcode.array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2019/5/12.
 * 找到数组中出现了两次的元素。
 * 【解题思路】
 *      1. 因为题意说数组的元素值的范围是： 1 ≤ a[i] ≤ n (n = size of array),。 所以，我们将数组值对应到新数组的元素下标，出现一次，值就+1，
 *      2. 最后判断新数组的元素值，如果大于二，就将这个元素的下标加入到 ret 中
 */
public class _442_Find_All_Duplicates_in_an_Array {
    public List<Integer> findDuplicates(int[] nums) {
        int[] arr = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            arr[nums[i]] ++;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for(int i = 1; i <= nums.length; i++) {
            if(arr[i] > 1)
                ret.add(i);
        }
        return  ret;
    }
}
