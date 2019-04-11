package leetcode.dp.sell_stock;

/**
 * Created by lenovo on 2019/4/11.
 * 买股票，没有手续费，只能买卖一次股票
 * 【解题思路】
 *     1. max表示获得的利润，lowIndex表示股票的最小价值。
 *     2. 如果当前的股票价值 - 曾经的最小的股票价值，就将利润更改
 *     3. 同时，每次循环，都记录曾经出现的最小利润值。
 */
public class _121_Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int lowIndex = 0,max = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] - prices[lowIndex] > max)
                max = prices[i] - prices[lowIndex];
            if(prices[i] < prices[lowIndex])
                lowIndex = i;
        }
        return  max;
    }
}
