package leetcode.string.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数组，找到数组中所有出现的频率大于等于总数组元素三分之一的元素
 *
 * CSDN: https://blog.csdn.net/xiaojie_570/article/details/92205394
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
