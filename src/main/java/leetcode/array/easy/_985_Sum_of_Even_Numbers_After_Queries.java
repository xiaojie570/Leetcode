package leetcode.array.easy;

/**
 * Created by lenovo on 2019/4/23.
 * 给出一个整数数组 A 和一个查询数组 queries。
 * 对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上。然后，第 i 次查询的答案是 A中偶数值的和。
 */
public class _985_Sum_of_Even_Numbers_After_Queries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int n = queries.length;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) sum += A[i];
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int d = queries[i][0], id = queries[i][1];
            if (A[id] % 2 == 0) sum -= A[id];
            A[id] += d;
            if (A[id] % 2 == 0) sum += A[id];
            result[i] = sum;
        }

        return result;
    }
}
