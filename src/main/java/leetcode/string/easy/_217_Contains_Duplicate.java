package leetcode.string.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lenovo on 2019/5/8.
     * 判断给定的数组是否有重复的元素
 */
public class _217_Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<Integer>();
        for(int num: nums) {
            if(hashSet.contains(num))
                return true;
            else
                hashSet.add(num);
        }
        return false;
    }
}
