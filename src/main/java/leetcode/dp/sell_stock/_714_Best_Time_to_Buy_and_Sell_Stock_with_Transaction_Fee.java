package leetcode.dp.sell_stock;

/**
 * Created by lenovo on 2019/4/11.
 * 有手续费的买股票
 */
public class _714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {
    public int maxProfit(int[] prices, int fee) {
        int empty = 0;
        int left = -prices[0]; //

        for (int i = 1; i < prices.length; i++) {
            int old_empty = empty;
            empty = Math.max(empty, left + prices[i] - fee); // 买当前股票能得到多少利润
            // 用old_empty - prices[i]的目的是买入prices[i]之后还剩下多少钱,就是决定买不买当前的股票，如果算完比之前的钱少了，就不买
            left = Math.max(left, old_empty - prices[i]);
        }
        return empty;
    }

    public static void main(String[] args) {
        int [] num = {1, 3, 2, 8, 4, 9};
        _714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee test = new _714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee();
        int ret = test.maxProfit(num,2);
        System.out.println(ret);
    }
}
