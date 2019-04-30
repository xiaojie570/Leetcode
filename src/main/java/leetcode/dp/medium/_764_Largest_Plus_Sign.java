package leetcode.dp.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lenovo on 2019/4/30.
 * 找到十字架，给定一个N（二维数组的长度和宽度），这个二维数组除了给定的 mines[][] 对应的位置为 0，其余的地方都为 1
 * 十字架是指：由元素 1 构成的四个方向等长图案。
 * 【解题思路】
 *      比如 011011111，向右扫描，遇1累加，遇0置0.初始值为0。可以得到0120123456（向右可扩展最大值）
 *      再向左扫描，得到123450120。再对每个位置取最小值。得到每个位置在该行可以扩展的最大长度：011012321.（向左可扩展最大值）
 *      同样，在垂直方向再进行一次，得到垂直方向上可以扩展的最大长度。
 *      最后,综合水平和垂直方向.
 * */
public class _764_Largest_Plus_Sign {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] dp = new int[N][N];
        Set<Integer> mineset = new HashSet<Integer>();
        for(int[] mine:mines){
            mineset.add(mine[0]*N + mine[1]);//相当于对每一个mine进行编号。
        }
        int ans = 0;
        for(int i = 0;i < N ;i++){
            int count = 0;
            for(int j = 0;j <N ;j++){
                count = mineset.contains(i * N + j)?0:count+1;
                dp[i][j] = count;
            }
            count = 0;
            for(int j = N-1;j>=0;j--){
                count = mineset.contains(i * N + j)?0:count+1;
                dp[i][j] = Math.min(dp[i][j],count);
            }
        }
        for(int j = 0;j < N ;j++){
            int count = 0;
            for(int i = 0;i <N ;i++){
                count = mineset.contains(i * N + j)?0:count+1;
                dp[i][j] = Math.min(dp[i][j],count);
            }
            count = 0;
            for(int i = N-1;i>=0;i--){
                count = mineset.contains(i * N + j)?0:count+1;
                dp[i][j] = Math.min(dp[i][j],count);
                ans = Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }
}
