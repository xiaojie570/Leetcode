package leetcode.array.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lenovo on 2019/4/11.
 * 给定一个数组，返回所有和为0的4个数。
 * 思路：
 *  1. 首先进行边界判断
 *  2. 对数组进行排序
 *  3. for循环里面，
 */
public class _18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) return res;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n-3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 不包含重复元素，所以如果两个数相等，就直接进行下一次循环
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target) {
                continue; // first candidate is too small 如果四个数的和小于目标值，则进行下一次循环，这种情况说明，第一个数小了。
            }
            for (int j = i + 1; j < n - 2; j++) {
                if (nums[i] + nums[j] + nums [j + 1] + nums[j + 2] > target) {
                    break; // 如果四个数的和大于target，则直接break这层循环，说明第一个数就大了
                }
                if (nums[i] + nums[j] + nums[nums.length - 1] + nums[nums.length - 2] < target) {
                    continue;  // 如果和小于目标值，说明第二个数应该取大一点
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = n - 1;
                while (left < right) { // 到这一层相当于求 2 Sum了。
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left ++;
                        right --;
                    } else if (sum < target) {
                        left ++;
                    } else {
                        right --;
                    }
                }
            }
        }
        return res;
    }
}
