package leetcode.array.stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by lenovo on 2019/5/14.
 * 找到给定数组的最大宽度，最大宽度的定义是：i < j 并且A[i] <= A[j]，那么这个宽度就是 j - i
 * 【解题思路】
 *      1. 构造单调递减栈：从第一个元素开始遍历整个容器（其中第一个元素必须入栈），若站定对应的元素大于当前元素值，则将当前元素对应的下标入栈，因为最后需要得到的是下标的差值
 *      2. 这样做的原理： 假设栈顶有一个元素 a， 当前元素是 b ， 若 b > a，则后续即使有一个元素 c 满足 c > b && b > a， 可能出现最大的宽度应该是 c - a
 *      3. 开始求最大的宽度：从后向前遍历数组中的元素，若出现当前元素大于栈顶对应的元素，则比较这个宽度和现有的宽度，取其中的最大值，弹出栈顶元素。重复这个操作。
 */
public class _962_Maximum_Width_Ramp {
    public int maxWidthRamp(int[] A) {
        if(A == null || A.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int ret = 0;
        for(int i = 0; i < A.length; i++) {
            if(stack.empty() || A[stack.peek()] > A[i])
                stack.add(i); // 存储的是下标
        }
        for(int i = A.length - 1; i >= 0; i--) {
            while(! stack.empty() && A[stack.peek()] <= A[i]) {
                ret = Math.max(ret, i - stack.pop());
            }
        }
        return ret;
    }
}
