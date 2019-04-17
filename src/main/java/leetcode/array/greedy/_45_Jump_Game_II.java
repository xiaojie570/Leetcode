package leetcode.array.greedy;

/**
 * Created by lenovo on 2019/4/17.
 * 给一个整型数组，每一位的元素指最大的跳数，最少需要多少次可以跳到终点
 */
public class _45_Jump_Game_II {
    public int jump(int[] nums) {
        int farMax = 0; // 最远能够到达的位置
        int lastMax = 0; // 上一次最远能够到达的位置
        int ret = 0; // 返回的次数
        for(int i = 0; i < nums.length; i++) {
            if(i > farMax) return -1; // 说明跳不到最后
            // 这个情况说明上一次跳的需要更新了，更新的值为farMax，说明上一次跳的最远位置不是最好的，
            // ret只加了1，就说明再上一次位置之前跳可以得到更远的位置
            if(i > lastMax) {
                lastMax = farMax;
                ret ++;
            }
            farMax = Math.max(farMax,i + nums[i]); // 更新能到达的最远位置
        }
        return ret;
    }
}
