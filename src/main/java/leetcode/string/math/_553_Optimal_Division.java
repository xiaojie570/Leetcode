package leetcode.string.math;

/**
 * Created by lenovo on 2019/5/19.
 * 给定一个数组，这个数组是一个连除的式子，我们需要在式子的不同位置加括号，保证最后的结果是最大的。
 * 【解题思路】
 *  因为给定的数组中的元素的值是[2,1000]，所以可以知道可以将第二个到最后一个元素括起来，这样相当于将元素的第一个元素和除了第二个元素之后所有元素相乘然后再除以第二个元素
 *  这样得到的结果最大。
 *
 *  1. 如果数组为空，或者数组中没有元素，则返回null
 *  2. 如果数组中的元素个数为1， 则返回这个数组的第一个元素
 *  3. 如果数组中的元素个数为2， 则返回这个数组的第一个元素除以第二个元素
 *  4. 如果数组中的元素个数超过2个，则进行计算第一个元素除以第二个元素乘以第三个元素后面的所有元素。
 */
public class _553_Optimal_Division {
    public String optimalDivision(int[] nums) {
        StringBuilder sb = new StringBuilder();
        if(nums == null || nums.length == 0)
            return null;
        else if(nums.length == 1)
            return nums[0] + "";
        else if(nums.length == 2) {
            return nums[0] + "/" + nums[1];
        }
        for(int i = 0; i < nums.length; i++) {
            if(i == 1) {
                sb.append("(");
                sb.append(nums[i]);
                sb.append("/");
            } else if(i == nums.length - 1)
                sb.append(nums[i]).append(")");
            else
                sb.append(nums[i]).append("/");
        }
        return sb.toString();
    }
}
