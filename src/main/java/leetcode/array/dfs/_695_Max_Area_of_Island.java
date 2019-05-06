package leetcode.array.dfs;

/**
 * Created by lenovo on 2019/5/6.
 * 给定一个二维数组，返回数组中的面积，即连续 1 的个数
 */
public class _695_Max_Area_of_Island {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;
        int ret = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                ret = Math.max(ret, help(grid,i,j));
            }
        }
        return ret;
    }

    private int help(int[][] grid, int i, int j) {
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            return help(grid,i - 1,j) + help(grid,i + 1, j) + help(grid,i,j - 1) + help(grid,i,j + 1) + 1;
        }
        return 0;
    }
}
