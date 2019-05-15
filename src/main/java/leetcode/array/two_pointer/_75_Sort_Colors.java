package leetcode.array.two_pointer;

/**
 * Created by lenovo on 2019/5/15.
 * 数组中一共就三类数：0,1,2，要求将所有的0放在最前面，1放在中间，2放在最右边
 * 【解题思路】
 *      可以先记录0,1,2的个数。
 *      然后有多少个0就存储多少个0，有多少个1就存储多少个1，有多少个2就存储多少个2，
 */
public class _75_Sort_Colors {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        int zero = 0, one = 0, two = 0;
        for(int num : nums) {
            if(num == 0)
                zero ++;
            else if(num == 1)
                one ++;
            else
                two ++;
        }
        int index = 0;
        while(zero -- > 0) {
            nums[index ++] = 0;
        }
        while(one -- > 0)
            nums[index ++] = 1;
        while(two -- > 0)
            nums[index ++] = 2;
        return;
    }
}
