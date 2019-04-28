package leetcode.dp.sum;

import java.util.Arrays;

/**
 * Created by lenovo on 2019/4/28.
 * 给我们一个数组nums，和一个数字k，问我们能不能把给定的数组分成k个非空子集合，使得每个子集合的和相同。
 * 给定的k的范围是[0,16],同时，数组中的元素都是正数。
 * 【解题思路】 用递归来做
 *      1. 因为是分成k个子集合，所以用dp很难做，这里考虑使用递归来做。
 *      2. 首先将给定的数组求和，判断和能否被给定的数字k整除，如果不能，直接返回false
 *      3. 然后调用递归函数，我们的目标是组成k个子集合，使得每个自己和的元素和为 sum / k。
 *          3.1 我们需要变量start，标志数组nums的访问位置，curSum表示当前子集合的和，
 *          3.2 在递归函数中，如果k = 1，说明这个时候只需要组一个子集合，那么当前集合就是，直接返回true
 *          3.3 如果curSum == target，说明已经组成了一个满足条件的子数组，那么我们继续调用递归，这个时候传入 k -1， start和curSum都为0。再继续寻找下一组子集合
 *
 *          3.4 访问下一组子集合的时候，如果当前元素被标记为已经访问过，则直接跳过，否则标记为已经访问，因为还在累加当前的子集合，所以K保持不变，start传入 i +1，curSum传入 curSum+nums[i]，
 *    【优化】
 *      我们在操作的时候先对数组进行排序,然后如果curSum 》target，那么直接返回false，这个剪枝操作会提高效率。
 */
public class _698_Partition_to_K_Equal_Sum_Subsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if(sum % k != 0) return false;
        sum /= k;
        int[] visited = new int[nums.length];
        return helper(nums, sum, visited, 0, k, 0);
    }
    public boolean helper(int[] nums, int target, int[] visited, int startIndex, int k, int curSum){
        if(k == 1) return true;
        if(curSum > target) return false;
        if(curSum == target ) return helper(nums, target, visited, 0, k-1, 0);
        for(int i = startIndex; i < nums.length; i++){
            if(visited[i]== 0){
                visited[i] = 1;
                if(helper(nums, target, visited, i+1, k, curSum + nums[i]))
                    return true;
                visited[i] = 0;
            }
        }
        return false;

    }
}
