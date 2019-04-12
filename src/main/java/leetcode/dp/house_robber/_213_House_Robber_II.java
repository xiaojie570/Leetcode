package leetcode.dp.house_robber;

/**
 * Created by lenovo on 2019/4/12.
 * 现在第一个房子和最后一个房子连在一起了，所以，抢了第一个房子就不能抢最后一个房子。
 */
public class _213_House_Robber_II {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];

        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]); // 可能会抢第一个房子
        dp2[0] = 0; // 不抢第一个房子
        dp2[1] = nums[1];

        for (int i = 2; i < nums.length - 1; i++) {  // 可能会抢第一个房子，所以最后一个房子肯定不能抢。
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
        }
        for (int i = 2; i < nums.length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
        }

        return Math.max(dp1[nums.length - 2], dp2[nums.length - 1]);
    }
}
