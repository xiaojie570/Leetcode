package leetcode.array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2019/5/14.
 * 找到给定的数组中出现次数超过 三分之一的元素。
 * 【解题思路】
 *  因为是三分之一，所以最多两个元素，那么只需要用两个变量去查找这两个元素就可以了。
 */
public class _229_Majority_Element_II {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int number1 = nums[0], number2 = nums[0], count1 = 0, count2 = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == number1) {
                count1++;
            }
            else if (nums[i] == number2) {
                count2++;
            }
            else if (count1 == 0) {
                number1 = nums[i];
                count1 = 1;
            }
            else if (count2 == 0) {
                number2 = nums[i];
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == number1) count1++;
            else if (num == number2) count2++;
        }
        if (count1 > n / 3) res.add(number1);
        if (count2 > n / 3) res.add(number2);
        return res;
    }
}
