package leetcode.array.medium;

/**
 * Created by lenovo on 2019/5/13.
 * 找到给定的数组的最大的环
 * Input: A = [5,4,0,3,1,6,2]
 * Output: 4
 * Explanation:
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 *
 * One of the longest S[K]:
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 */
public class _565_Array_Nesting {
    public int arrayNesting(int[] nums) {
        int start = -1;
        boolean[] visited = new boolean[nums.length];
        int max = 0;
        while(++start  < nums.length) {
            if(visited[start]) continue;
            int temp = 0;
            int i = start;
            while(! visited[i]) {
                visited[i] = true;
                i = nums[i];
                temp ++;
            }
            max = Math.max(max, temp);
        }
        return max;
    }
}
