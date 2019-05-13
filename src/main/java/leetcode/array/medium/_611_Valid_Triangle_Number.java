package leetcode.array.medium;

import java.util.Arrays;

/**
 * Created by lenovo on 2019/5/13.
 * 找到数组中能组成多少个三角形
 */
public class _611_Valid_Triangle_Number {
    public int triangleNumber(int[] nums) {
        int ret = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            if(nums[i] == 0) continue;
            int k = i + 2;
            for(int j = i + 1; j < nums.length - 1;j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k])
                    k++;
                ret += k - j - 1;
            }
        }
        return ret;
    }
}
