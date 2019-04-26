package leetcode.dp.medium;

import java.util.Arrays;

/**
 * Created by lenovo on 2019/4/26.
 * 如果 N = 1，则相当于不用操作，因为notepad上初始化就有1个A字符。
 如果 N = 2，要生成AA，则需要复制，粘贴各一次，此时output为2。
 如果 N = 3，要生成AAA，则复制1次A，然后粘贴2次A；此时output为3。
 如果 N = 4，要生成AAAA，有2种方法:
 1.复制1次A，然后粘贴1次A， 再复制1次AA再粘贴1次AA，此时output为4。
 ii.复制1次A，连续粘贴3次A，此时output也为4。

 【解题思路】
 dp[n]表示生成n个字符所需的最小操作次数
 dp[0, .. , n]初始为∞
 dp[0] = dp[1] = 0

 状态转移方程： dp[x] = min(dp[x], dp[y] + x / y) ，y ∈[1, x) 并且 x % y == 0
 */
public class _650_2_Keys_Keyboard {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        if(n == 0 || n == 1)
            return 0;
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j < i ;j++)
                if(i % j == 0)
                    dp[i] = Math.min(dp[i],dp[j] + i/j);
        }
        return dp[n];
    }
}
