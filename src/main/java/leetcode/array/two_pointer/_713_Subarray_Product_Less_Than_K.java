package leetcode.array.two_pointer;

/**
 * Created by lenovo on 2019/5/16.
 * 找到连续数组的乘积小于K的子数组的个数
 */
public class _713_Subarray_Product_Less_Than_K {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ret = 0;
        int j = 0;
        int sum = 1;
        for(int i = 0; i < nums.length; i++) {
            sum *= nums[i];
            while(sum >= k) {
                sum /= nums[j];
                j ++;
            }
            ret += (i - j + 1);  // 这个公式很厉害
        }
        return ret;
    }
}
