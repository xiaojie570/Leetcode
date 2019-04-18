package leetcode.dp.hands;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by lenovo on 2019/4/18.
 * 手拉手问题
 * Input: [[1,2], [2,3], [3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4]
 * 【解题思路】
 *   1. 首先对数组进行排序，按照尾巴排序
 *   2. 循环，如果存储的尾巴小于当前的第一个元素，则不能拉手，需要将ret++，将尾巴更新为当前元素的尾巴。
 */
public class _646_Maximum_Length_of_Pair_Chain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int ret = 1;
        int cur = pairs[0][1];
        for(int i = 1; i < pairs.length; i++) {
            if(cur < pairs[i][0]) {
                ret ++;
                cur = pairs[i][1];
            }
        }
        return ret;
    }
}
