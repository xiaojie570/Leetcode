package leetcode.array.greedy;

/**
 * Created by lenovo on 2019/4/17.
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 给一个整型数组，每一位的元素指最大的跳数，问是否可以走到最后一个元素
 * 【解题思路】
 *      1. 首先定义一个变量maxReach，用来存储在当前位置走最大跳数的时候可以到达的位置
 *      2. 再定义一个变量temp表示每次只走一步能到达的位置
 *      3. 进行while循环，通过比较temp每次走一步和maxReach每次走最大步数，来决定是否可以走到最后一个元素
 */
public class _55_Jump_Game {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        int temp = 0;
        while(temp <= maxReach && temp < nums.length) {
            maxReach = Math.max(maxReach,temp + nums[temp]);
            temp ++;
        }
        return maxReach >= nums.length - 1;
    }
}
