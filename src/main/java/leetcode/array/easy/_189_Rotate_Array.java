package leetcode.array.easy;

/**
 * Created by lenovo on 2019/5/9.
 * 反转数组，给定一个数组，和一个元素k，将后面的k个元素反转到数组的前面
 * 【解题思路】
 *  三步反转法：
 *  1. 将前nums.length - k - 1个元素反转，就是后面的放到前面，两个指针
 *  2. 将nums.length - k  到最后的元素反转
 *  3. 将整个数组中的元素反转
 *
 *  CSDN: https://blog.csdn.net/xiaojie_570/article/details/91416362
 */
public class _189_Rotate_Array {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length - k - 1);
        reverse(nums,nums.length - k,nums.length - 1);
        reverse(nums,0,nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }

}
