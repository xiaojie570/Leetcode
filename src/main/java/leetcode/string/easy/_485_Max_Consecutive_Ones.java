package leetcode.string.easy;

/**
 * Created by lenovo on 2019/5/8.
 * 返回有多少连续的1
 */
public class _485_Max_Consecutive_Ones {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int retMax = 0;
        int local = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1)
                local ++;
            else {
                local = 0;
            }
            retMax = Math.max(retMax,local);
        }
        return retMax;
    }

    public static void main(String[] args) {
        _485_Max_Consecutive_Ones test = new _485_Max_Consecutive_Ones();
        test.findMaxConsecutiveOnes(new int[]{1});
    }
}
