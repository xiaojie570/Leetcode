package leetcode.array.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by lenovo on 2019/5/14.
 * 给定一个二维数组，合并重合的部分。
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * 【解题思路】
 *      1. 定义两个一维数组，第一个一维数组存储二维数组的第一列。第二个一维数组存储二维数组的第二列
 *      2. 排序两个数组。
 *      3. 比较对应的位置的元素的大小。
 *      4. 最后将元素放到返回的二维数组中
 */
public class _56_Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> list = new ArrayList<List<Integer>> ();
        if(intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0)
            return new int[0][0];
        int length = intervals.length;
        int[] a = new int[length];
        int[] b = new int[length];
        for(int i = 0; i < length; i++) {
            a[i] = intervals[i][0];
            b[i] = intervals[i][1];
        }
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i = 0; i < length - 1; i ++) {
            if(b[i] < a[i + 1])
                list.add(Arrays.asList(a[i],b[i]));
            else
                a[i + 1] = a[i];
        }
        list.add(Arrays.asList(a[length - 1],b[length - 1]));
        int[][] ret = new int[list.size()][2];
        for(int i = 0; i < ret.length; i++) {
            ret[i][0] = list.get(i).get(0);
            ret[i][1] = list.get(i).get(1);
        }
        return ret;
    }

    public static void main(String[] args) {
        _56_Merge_Intervals test = new _56_Merge_Intervals();
        int[][] a = {{1,10},{8,9},{10,11}};
        test.merge(a);
    }
}
