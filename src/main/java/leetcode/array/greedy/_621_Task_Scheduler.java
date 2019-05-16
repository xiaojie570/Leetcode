package leetcode.array.greedy;

import java.util.Arrays;

/**
 * Created by lenovo on 2019/5/16.
 * 题意：模拟CPU任务分配，A到Z表示不同的任务，任务可以以不同顺序进行。每个任务可以在一个时间间隔完成。
 * 对于一个时间间隔，CPU可以执行一个任务或者是限制，但是，两个同样的任务之间需要有n个冷却时间，即假如A执行之后，那么未来n个时间间隔，A是不可以再执行的。
 * 【解题思路】
 *      首先使用一个26位的数组来存储每个元素的个数
 */
public class _621_Task_Scheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];  // 存储每个元素的个数
        for(char c: tasks)
            arr[c - 'a'] ++;
        Arrays.sort(arr); // 排序之后，最后一个元素应该是数组重复元素最多的元素
        int i = 25;
        while(i >= 0 && arr[i] == arr[25]) i--; //找到第一个数组元素重复的个数小于最多的元素位置
        return Math.max(tasks.length,(arr[25] - 1) * (n + 1) + 25 - i);
    }
}
