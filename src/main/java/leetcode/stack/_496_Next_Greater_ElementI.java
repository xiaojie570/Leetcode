package leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by lenovo on 2019/4/22.
 * 给两个数组 findNums 和 nums， 返回一个和 findNums等长的数组，其返回的内容为：对于findNums[i]，返回的result[i] 为nums[i]数组中，
 * findNums[i] 的后面的元素中第一个比findNums[i]大的元素。如果不存在这样的元素就写-1.
 * 【解题思路】
 *  使用栈，从后往前遍历nums[i]，每当栈不为空的时候，一直出栈，知道遇到比nums[i]大的数字停止。设立一个 map<int,int> 存储 nums中每个元素以及
 *  它对应的下一个最大元素构成的映射。
 */
public class _496_Next_Greater_ElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        for(int num: nums2) {
            while(!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(),num);
            }
            stack.push(num);
        }
        for(int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i],-1);
        }
        return nums1;
    }
}
