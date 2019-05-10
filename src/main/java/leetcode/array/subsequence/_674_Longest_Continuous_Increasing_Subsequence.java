package leetcode.array.subsequence;

/**
 * Created by lenovo on 2019/5/10.
 * 最长连续递增子序列
 */
public class _674_Longest_Continuous_Increasing_Subsequence {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int compare = 0; // 0-> 相等 1-> 小于 2 -> 大于
        int maxLength = 1, localLength = 1;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] < nums[i + 1]) localLength ++;
            else {
                maxLength = Math.max(maxLength,localLength);
                localLength = 1;
            }
        }
        maxLength = Math.max(maxLength,localLength);
        return maxLength;
    }

    public static void main(String[] args) {
        _674_Longest_Continuous_Increasing_Subsequence test = new _674_Longest_Continuous_Increasing_Subsequence();
        int[] a = {1,3,5,7};
        test.findLengthOfLCIS(a);
    }
}
