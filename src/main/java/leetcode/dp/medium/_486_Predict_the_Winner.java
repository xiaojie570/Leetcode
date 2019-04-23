package leetcode.dp.medium;

/**
 * Created by lenovo on 2019/4/23.
 */
public class _486_Predict_the_Winner {
    public boolean PredictTheWinner(int[] nums) {
        int[][] ret = new int[nums.length][nums.length];
        return help(nums,0,nums.length - 1, ret) >= 0;
    }

    private int help(int[] nums, int left, int right, int[][] ret) {
        if(left == right)
            return nums[left];
        if(ret[left][right] != 0)
            return  ret[left][right];
        int a = nums[left] - help(nums,left + 1,right,ret);
        int b = nums[right] - help(nums,left,right - 1,ret);
        ret[left][right] = Math.max(a,b);
        return  ret[left][right];
    }

    public static void main(String[] args) {
        _486_Predict_the_Winner test = new _486_Predict_the_Winner();
        int[] n = {1,5,233,7};
        test.PredictTheWinner(n);
    }
}
