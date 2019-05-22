package leetcode.array.medium;

/**
 * Created by lenovo on 2019/5/22.
 * 给一个数组，和两个变量L 和 R， 要求返回连续的子数组的个数，这些子数组需要满足最大的元素值最少是 L， 最大是R
 */
public class _795_Number_of_Subarrays_with_Bounded_Maximum {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        if(A == null || A.length == 0)
            return 0;
        int ret = 0;
        int count = 0;
        int j = 0; // 当前元素前面符合的连续子数组的第一个位置
        for(int i = 0 ; i < A.length; i++) {
            if(A[i] >= L && A[i] <= R) {
                count = i - j  + 1;
                ret += count;
            } else if(A[i] < L)
                ret += count; // 如果当前元素不能单独带领数组，那么当前元素插入进来能够组成的数组数与最接近的一个[L,R]元素是相同的
            else {
                j = i + 1;
                count = 0;
            }
        }
        return ret;
    }
}
