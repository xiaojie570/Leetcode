package leetcode.dp.medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Created by lenovo on 2019/5/29.
 * 最大可整除的子集合
 * 给我们一个数组，让我们求其子集合，集合中的任意两个数相互取余均为0。
 * 【解题思路】
 *  1. 先将数组进行排序，因为较小数 取余 较大数，余数一定不为 0
 *  2. 排序后只需要判断后面的数能否整除前面的数字就可以了。
 */
public class _368_Largest_Divisible_Subset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int[] pre = new int[n];
        int max = 0, index = -1;
        Arrays.sort(nums);  // 对数组进行排序
        for(int i = 0; i < n; i++) {
            count[i] = 1;
            pre[i] = -1;
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] % nums[j] == 0) {
                    if(count[j] + 1 > count[i]) {
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if(count[i] > max) {  // 找到最大的元素个数
                max = count[i];
                index = i;
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        while(index != -1) {
            res.add(nums[index]);
            index = pre[index];
        }
        return res;
    }
}
