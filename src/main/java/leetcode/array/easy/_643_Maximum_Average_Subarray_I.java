package leetcode.array.easy;

/**
 * Created by lenovo on 2019/5/9.
 * 给定一个n个元素的整型数组，找到连续长度为k的子数组，使得他们的和最大。
 * 【解题思路】
 *  1. 首先将前k个元素的和求出来
 *  2. 其次，遍历数组中的元素，从第k个元素开始，每次加一个元素，并且减去最前面已经累加的一个元素，这样保证sum中的和永远是k个元素的和。
 *  3. 每遍历一个元素，都比较当前的和是否比原来的和大，如果大的话，就替换一下。
 *  4. 注意最后需要强制类型转换一下。
 *
 *  CSDN: https://blog.csdn.net/xiaojie_570/article/details/91491982
 *
 */
public class _643_Maximum_Average_Subarray_I {
    public double findMaxAverage(int[] nums, int k) {
        if(nums == null || nums.length < k)
            return 0;
        int sum = 0;
        int max = 0;
        for(int i = 0; i < k; i++)
            sum += nums[i];
        max = sum;
        for(int i = k; i < nums.length;i++) {
            sum = sum + nums[i] - nums[i - k];
            if(sum > max)
                max = sum;
        }
        return (double)((double)max / (double)k);
    }

    public static void main(String[] args) {
        int [] a = {1,12,-5,-6,50,3};
        _643_Maximum_Average_Subarray_I test = new _643_Maximum_Average_Subarray_I();
        test.findMaxAverage(a,4);
    }
}
