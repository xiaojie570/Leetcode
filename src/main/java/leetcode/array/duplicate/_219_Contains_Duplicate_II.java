package leetcode.array.duplicate;

import java.util.HashMap;

/**
 * Created by lenovo on 2019/5/10.
 * 给一个数组，和一个整数k，判断该数组是否存在不同下标的i和j两个元素，使得nums[i] == nums[j]，并且i和j的差不超过k
 *
 *
 */
public class _219_Contains_Duplicate_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length;i++) {
            if(hashMap.containsKey(nums[i]) && (i - hashMap.get(nums[i]) <= k))
                return true;
            hashMap.put(nums[i],i);
        }
        return false;
    }

    public static void main(String[] args) {
        _219_Contains_Duplicate_II test = new _219_Contains_Duplicate_II();
        int []a = {1,0,1,1};
        test.containsNearbyDuplicate(a,1);
    }
}
