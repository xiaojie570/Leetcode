package leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by lenovo on 2019/4/22.
 */
public class _503_Next_Greater_ElementII {
    public int[] nextGreaterElements(int[] nums) {
        int [] next = new int[nums.length];
        Stack<Integer> stack  = new Stack<Integer>();
        for(int i = 0 ; i < nums.length * 1; i++) {
            int num = nums[i % nums.length];
            while(! stack.isEmpty() && nums[stack.peek()] < num) {
                nums[stack.pop()] = num;
            }
            if(i < nums.length)
                stack.push(i);  // stack 里面存储的是元素的下标
        }
        return nums;
    }

    public static void main(String[] args) {
        _503_Next_Greater_ElementII test = new _503_Next_Greater_ElementII();
        int [] nums = {1,2,1};
        nums = test.nextGreaterElements(nums);

    }
}
