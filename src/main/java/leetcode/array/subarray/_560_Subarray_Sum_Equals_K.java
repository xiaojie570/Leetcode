package leetcode.array.subarray;

import java.util.HashMap;

/**
 * Created by lenovo on 2019/5/13.
 * 给定一个数组和一个整数k，找到连续子元素的和等于k的子数组的个数。
 * 【解题思路】
 *      使用hashmap来做
 */
public class _560_Subarray_Sum_Equals_K {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
        for(int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        int ret = 0;
        hashMap.put(0,1);
        for(int num : nums) {
            if(hashMap.containsKey(num - k)) {
                ret += hashMap.get(num - k);
            }
            int temp = hashMap.getOrDefault(num,0) + 1;
            hashMap.put(num,temp);
        }
        return  ret;
    }

    public static void main(String[] args) {
        _560_Subarray_Sum_Equals_K test = new _560_Subarray_Sum_Equals_K();
        int[] a = {1};
        test.subarraySum(a,0);
    }
}
