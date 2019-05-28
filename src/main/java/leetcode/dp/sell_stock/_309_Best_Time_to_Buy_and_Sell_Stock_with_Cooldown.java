package leetcode.dp.sell_stock;

/**
 * Created by lenovo on 2019/5/28.
 * 带有冷冻期Cooldown的买卖股票问题
 *  即：如果某天卖了股票，那么第二天就不能买股票，有一天的冷冻期。
 *  【解题思路】
 *
 */
public class _309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
    public int maxProfit(int[] prices) {
        int sellProfit = 0; // 卖的利润
        int coolProfit = 0; // 冰点的利润
        for(int i =1; i < prices.length;i++){
            int temp = sellProfit;  // 卖的利润
            sellProfit = Math.max(sellProfit+(prices[i] - prices[i-1]), coolProfit); // 如果遇到买前一天的卖今天的导致利润变少了，那就把前一天的作为冰点。
            coolProfit = Math.max(temp, coolProfit); // 如果把它作为冰点的利润
        }
        return Math.max(coolProfit, sellProfit);
    }

    public static void main(String[] args) {
        _309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown test = new _309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown();
        int[] a = {1,2,3,0,2};
        test.maxProfit(a);
    }
}
