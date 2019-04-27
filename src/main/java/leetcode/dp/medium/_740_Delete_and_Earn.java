package leetcode.dp.medium;

/**
 * Created by lenovo on 2019/4/27.
 * 我们可以从一堆数中挑选一个数，然后删除比它大1和小1的数，这个数的值作为挑选这个数的分值，问最后最多可以拿到多少分
 * 【解题思路】
 *      如果我们有很多重复的数，那么我们一旦拿了其中的一个数，就要把它拿完，因为我们一旦拿了一个数之后，它就没有这个数的+1和-1了，
 *      如果我们不拿完这个数，那一定会剩下这个数。
 *      这里我们采用桶装法，每个桶的下标对应给定的数组的数，桶里的值代表这个数*数的个数，即值为这个数的所有和。
 *
 *      状态转移方程：
 *        我们拿不拿当前数的规定应该是，拿去当前数的分应该等于当前数的分 + 当前数的前一个的前一个数的分之和，与 不拿当前数而拿钱当前数的前一个数我们能够得到的分数，
 *        这两个分我们选择最大的，作为当前数的分。
 */
public class _740_Delete_and_Earn {
    public int deleteAndEarn(int[] nums) {
        int[] values = new int[10000];
        for(int num: nums)
            values[num] += num;
        int take = 0, skip = 0;
        for(int i = 0; i < 10000; i++) {
            int takeCur = values[i] + skip; // 拿当前的元素
            skip = Math.max(take,skip); // 不拿当前的元素
            take = takeCur; // 更新一下为了下一次使用
        }
        return Math.max(take,skip);
    }
}
