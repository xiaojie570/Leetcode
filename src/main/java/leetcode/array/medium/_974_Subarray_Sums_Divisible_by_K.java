package leetcode.array.medium;

/**
 * Created by lenovo on 2019/5/22.
 * 在一个数组中有多少个连续子数组的和，敲好能被K整除。
 * 【解题思路】
 *      定义DP数组，其中dp[i]代表以i结尾的能被K整除的子数组的最多个数
 *      1. 既然要求子数组的和，我们就要求数组累积和 sum。
 */
public class _974_Subarray_Sums_Divisible_by_K {
    public int subarraysDivByK(int[] A, int K) {
        int[] sameMod = new int[A.length];  // 存储具有相同余数的前缀和数目
        int ret = 0;
        int sum = 0;
        for(int arr : A) {
            sum += arr; // 当前元素与前面的所有元素的和
            int mod = ((sum % K) + K) % K;  // 余数，这个地方不是单纯的 sum  % k 的原因是：这个r 要作为之后的下标，所以不能是负数
            if(mod == 0)
                ret ++;  // 如果前缀和可以整除 k，就将返回值 ++
            ret += sameMod[mod] ++;  // 这一步很重要。
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(-4 % 5);
    }
}
