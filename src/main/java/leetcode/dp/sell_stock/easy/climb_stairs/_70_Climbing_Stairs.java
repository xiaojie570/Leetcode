package leetcode.dp.sell_stock.easy.climb_stairs;

/**
 * Created by lenovo on 2019/4/12.
 * 有多少种爬楼梯的方法?
 * 【解题思路】斐波那契数列
 *   1. 首先要判断当楼梯只有一层，只有两层的时候
 *   2. 当楼梯大于2层的时候，要将前面的数据初始化，就是对应的一层和两层的值初始化出来。
 *         当前层有多少种上来的方法应该等于当前层前一层的方法数 + 当前层前前层的方法数
 */
public class _70_Climbing_Stairs {
    public int climbStairs(int n) {
        if(n == 0 || n == 1) // 当楼梯只有一层的时候，只有一种方法
            return 1;
        else if(n == 2) // 当楼梯有两层的时候，有两种方法
            return 2;
        else {
            int[] step = new int[n + 1];
            step[0] = 1;
            step[1] = 1;
            step[2] = 2;
            int i = 3;
            while(i <= n) {
                step[i] = step[i - 1] + step[i - 2];
                i ++;
            }
            return step[n];
        }
    }
}
