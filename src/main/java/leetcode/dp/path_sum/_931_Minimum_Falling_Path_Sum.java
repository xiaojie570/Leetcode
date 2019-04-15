package leetcode.dp.path_sum;

/**
 * Created by lenovo on 2019/4/15.
 * 已知一个正方形二维数组A，我们想要找到一条最小下降路径的和。
 * 所谓下降路径是指，从一行到下一行，只能选择间距不超过1的列，最小下降路径就是这个路径的和最小。
 * 【解题思路】
 *      1. 首先要定义一个boolean类型的二维数组visited，用于记录当前元素是否被访问过，因为后面会把A数组的值更改为到达这一步最小路径，
 *          所以有一个记录数组可以减少计算的次数。
 *      2. 我们只需要遍历第一行的元素，然后通过dfs的方式去一次遍历每一列就可以了。
 *      3. 注意dfs的时候的终止条件有两个，一个是当前元素被访问过，另一个是当前元素的到达了最后一行。
 */
public class _931_Minimum_Falling_Path_Sum {
    public int minFallingPathSum(int[][] A) {
        if(A == null || A.length == 0 || A[0] == null || A[0].length == 0) return 0;
        int min = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[A.length][A[0].length];
        for(int i = 0; i < A[0].length; i++) {
            min = Math.min(min,dfs(A,visited,0,i));
        }

        return min;
    }

    private int dfs(int[][] A, boolean[][] visited, int row, int col) {
        if(visited[row][col])
            return A[row][col];

        if(row == A.length - 1)
            return A[row][col];

        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(col - 1 >= 0)
            left = dfs(A,visited,row + 1,col - 1);
        int mid = dfs(A,visited,row + 1,col);
        if(col < A[0].length - 1)
            right = dfs(A,visited,row + 1,col + 1);
        int min = Math.min(left,Math.min(right,mid)) + A[row][col];
        visited[row][col] = true;
        A[row][col] = min;
        return min;
    }

    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        _931_Minimum_Falling_Path_Sum test = new _931_Minimum_Falling_Path_Sum();
        int ret = test.minFallingPathSum(a);
        System.out.println(ret);
    }
}
