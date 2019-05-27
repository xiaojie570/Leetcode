package leetcode.dp.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2019/5/27.
 * 给一个N和一个K，N是N位数字，保证每一位之间的绝对值之差为K，返回所有能组成这样的数。
 */
public class _967_Numbers_With_Same_Consecutive_Differences {
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> ret = new ArrayList<Integer>();
        helper(N,N,K,0,0,ret);
        int[] arr = new int[ret.size()];
        for(int i = 0; i < arr.length; i++)
            arr[i] = ret.get(i);
        return arr;
    }

    private void helper(int N, int N0, int K, int cur, int last, List<Integer> ret) {
        if(N == 0) {
            ret.add(cur);
            return;
        }
        for(int i = 0; i < 10; i++) {
            if(N > 1 && i == 0 && N == N0) continue;
            if(N == N0 || Math.abs(last - i) == K)
                helper(N - 1, N0, K, cur * 10 + + i, i, ret);
        }
    }
}
