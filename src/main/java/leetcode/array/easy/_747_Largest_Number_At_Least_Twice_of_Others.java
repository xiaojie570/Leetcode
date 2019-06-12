package leetcode.array.easy;

/**
 * Created by lenovo on 2019/5/10.
 *  找到数组中最大的数字，如果他比其他所有的数字都大2倍及以上，则返回最大元素的索引值，否则返回 - 1
 *  【解题思路】
 *      1. 首先找到数组中的最大元素和第二大元素以及最大元素的下标
 *      2. 最后比较最大元素是否是第二大元素的2倍多，如果是，则返回下标，如果不是则返回 - 1；
 *
 *   CSDN: https://blog.csdn.net/xiaojie_570/article/details/91507659
*/
public class _747_Largest_Number_At_Least_Twice_of_Others {
    public int dominantIndex(int[] nums) {
        if(nums == null || nums.length <= 0)
            return -1;
        int max = 0, seconde = 0, ret = 0;
        int i = 0;
        for(; i < nums.length; i++) {
            if(nums[i] > max) {
                ret = i;
                seconde = max;
                max = nums[i];
            } else if(nums[i] > seconde)
                seconde = nums[i];
        }

        return  (max / 2 >= seconde) ? ret : -1;


        /*if(nums == null || nums.length == 0)
            return -1;
        int max = 0, ret = -1;
        int i = 0;
        for(; i < nums.length; i++) {
            if(nums[i] > max) {
                ret = i;
                max = nums[i];
            }
        }
        for(i = 0; i < nums.length; i++) {
            if(i != ret && nums[i] * 2 >max)
                return -1;
        }
        return  ret;*/
    }

    public static void main(String[] args) {
        _747_Largest_Number_At_Least_Twice_of_Others test = new _747_Largest_Number_At_Least_Twice_of_Others();
        int a[] = {0,0,0,1};
        test.dominantIndex(a);
    }
}
