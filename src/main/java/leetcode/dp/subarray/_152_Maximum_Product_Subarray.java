package leetcode.dp.subarray;

/**
 * Created by lenovo on 2019/4/13.
 * 连续子元素的最大的乘积
 * 【解题思路】
 *      1.首先要判断给定数组是否为空，是否长度为 0
 *      2. 两次for循环，每一次里面都计算乘以当前元素的结果cur，max的值等于max值与cur的最大值
 *          2.1 如果cur == 0，说明当前值为0，那么就要抛弃之前乘以过的值，因为0乘以任何数都等于0，将cur重新置为 1
 *          2.2 两次for 循环的目的是防止遇到了 10 -4 155 的情况，从前面往后算的max为10 从后往前算的max 为 155。
 *
 *
 *     CSDN: https://blog.csdn.net/xiaojie_570/article/details/91444029
 */
public class _152_Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int cur = 1, max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            cur = cur * nums[i];
            max = Math.max(cur,max);
            if(cur == 0)
                cur = 1;
        }
        cur = 1;
        for(int i = nums.length - 1; i >= 0; i --) {
            cur = cur * nums[i];
            max = Math.max(cur, max);
            if(cur == 0)
                cur = 1;
        }
        return max;
    }
}
