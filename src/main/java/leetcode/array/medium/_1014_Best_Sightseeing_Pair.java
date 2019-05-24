package leetcode.array.medium;

/**
 * Created by lenovo on 2019/5/24.
 * 对于数组中的下标 i和j，求A[i] + A[j] + i - j 的最大值
 */
public class _1014_Best_Sightseeing_Pair {
    public int maxScoreSightseeingPair(int[] A) {
        if(A.length < 2)
            return 0;
        int curMax = A[0];
        int ret = 0;
        for(int i = 1; i < A.length; i++) {
            curMax --; // 这里 -- 其实是实现了 i - j 的操作。每遍历一次，对应的两个元素的距离差就应该增加 1
            ret = Math.max(ret, curMax + A[i]);
            curMax = Math.max(curMax,A[i]); // 用于存储当前值
        }
        return ret;
    }
}
