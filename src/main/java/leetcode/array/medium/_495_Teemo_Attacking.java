package leetcode.array.medium;

/**
 * Created by lenovo on 2019/5/23.
 * 给一个数组和一个数字，数组中元素是升序的，每一个元素代表释放毒气的时间点，数字duration表示释放毒气能够中毒的时间，
 * 比如时间点 1 开始攻击，持续2秒，则在第2秒结束后才会恢复不中毒，如果前一次正在中毒中而后一次提早又被攻击了，那就是最后一次攻击 +持续时间才会恢复中毒。
 * 返回这个人一共中毒了多少秒
 *
 * 【解题思路】
 *      这个题也不是比较好想出来的。
 *      1. 首先定义一个start变量记录中毒起始时间，定义一个end变量记录中毒结束的时间
 *      2. 然后遍历如果当前的开始时间在上一次的结束时间之后，则正常增加一个完整的中毒时间，然后更新新的起始中毒时间，更新新的中毒结束时间
 *      3. 最后还要加一个 end - start 是因为最后一次攻击也要计算上对应的持续时间。
 */
public class _495_Teemo_Attacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries == null || timeSeries.length == 0 || duration == 0)
            return 0;
        int ret = 0;
        int start = timeSeries[0], end = timeSeries[0] + duration;
        for(int i = 1; i < timeSeries.length; i++) {
            if(timeSeries[i] > end) {
                ret += end - start;
                start = timeSeries[i];
            }
            end = timeSeries[i] + duration;
        }
        return ret + end - start;  // 最后还要加一个 end - start 是因为最后一次攻击也要计算上 这个地方一定是 end - start 不能是duration
    }
}
