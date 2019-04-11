package leetcode.dp.sell_stock;

/**
 * Created by lenovo on 2019/4/11.
 * 买卖股票。可以无限次的买入和卖出
 * 【解题思路】 贪婪
 *  因为我们可以无限次的买入和卖出，所以我们只需要在低价买入高价卖出就可以，
 *  我们只需要从第二天开始如果当前价格比前面的价格高，我们就把前一天的买入，今天卖出，
 *  如果明天价格比今天价格更高的话，我们就今天再买入，明天再卖出即可。
 */
public class _122_Best_Time_to_Buy_and_Sell_Stock_II {
    public int maxProfit(int[] prices) {
        int pre = 0, i = 0, profile = 0,n = prices.length - 1, buy,sell;
        while(i < n) {
            while(i < n && prices[i + 1] <= prices[i]) i ++; // 找到比前面值小的那个值
            buy = prices[i];
            while(i < n && prices[i + 1] > prices[i]) i ++;
            sell = prices[i];
            profile += sell - buy;
        }
        return profile;
    }
}
