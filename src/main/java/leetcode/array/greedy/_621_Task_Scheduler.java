package leetcode.array.greedy;

/**
 * Created by lenovo on 2019/5/16.
 *
 */
public class _621_Task_Scheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];  // 存储每个元素的个数
        for(char c: tasks)
            arr[c - 'a'] ++;

    }
}
