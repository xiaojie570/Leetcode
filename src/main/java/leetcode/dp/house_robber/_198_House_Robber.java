package leetcode.dp.house_robber;

/**
 * Created by lenovo on 2019/4/12.
 */
public class _198_House_Robber {
    public int rob(int[] nums) {
        int rob = 0;
        int notrob = 0;
        for(int i = 0; i < nums.length; i++) {
            int currob = notrob + nums[i]; // 中间的临时变量
            notrob = Math.max(notrob,rob); // 不抢劫当前的房子，那要找到不抢劫的话的值
            rob = currob; // 抢劫当前的房子，那要找到抢劫的话的值
        }
        return Math.max(rob,notrob);
    }
}
