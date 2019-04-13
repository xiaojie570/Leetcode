package leetcode.dp.subarray;

/**
 * Created by lenovo on 2019/4/13.
 * 给定一个字符数组，找到连续子元素的最大的和
 * 【解题思路】
 *  1. 如果和sum小于0，就把之前的和抛弃，变为当前元素的值
 *  2. 如果和sum大于0，就加上当前元素的值作为新的和sum
 *  3. 每次循环都更新返回值max的值，判断之前的max与新和sum大小，得到大的放到max中
 */
public class _53_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(sum < 0)
                sum = nums[i];
            else
                sum += nums[i];
            max = Math.max(max,sum);
        }
        return max;
    }
}
