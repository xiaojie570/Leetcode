package leetcode.dp.greedy;

/**
 * Created by lenovo on 2019/4/30.
 * 摆动序列，就是一个序列，相邻两个数相减，组成的新序列是按照正负正负正负。。。这么排列的序列
 * 求一个序列的最长摆动子序列的长度。
 * 【解题思路】
 *      找一个标志位 flag，记下前一个做差的符号，遍历数组，用本次的差和flag相比，本次的差是0就忽略掉，
 *      本次的差和之前一样也忽略掉。
 *      把不是摆动序列通过删除元素来改成摆动序列。从贪心算法的思想考虑，应该删除最后一个元素
 */
public class _376_Wiggle_Subsequence {
    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        if(length == 0)
            return 0;
        int ret = 1, flag = 0;
        for(int i =1; i < length; i++) {
            int a = nums[i] - nums[i - 1];
            if(a != 0) {
                a = a / Math.abs(a); // 变为 1 或者 -1
            } else
                continue;;
            if(a != flag) // 是摆动的
                ret ++;
            flag = a; // 更新标志位
        }
        return ret;
    }
}
