package leetcode.dp.climb_stairs;

/**
 * Created by lenovo on 2019/4/12.
 * 最小成本爬楼梯
 * 有一个楼梯，第i阶用cost[i]表示成本。现在你需要支付爬楼梯的成本，可以一次走两台阶，也可以走一个台阶
 * 问，从地面或者第一阶出发，怎么走成本最小。
 * 【解题思路】
 *      我们是看不到很高层楼梯的代价的，所以我们只能从底层台阶往上走，只要当前层走的是最小代价就可以了。
 */
public class _746_Min_Cost_Climbing_Stairs {
    public int minCostClimbingStairs(int[] cost) {
        for(int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i - 1],cost[i - 2]);
        }
        return Math.min(cost[cost.length - 1],cost[cost.length - 2]);
    }
}
