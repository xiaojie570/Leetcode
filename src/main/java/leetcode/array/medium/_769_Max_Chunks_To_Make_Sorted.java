package leetcode.array.medium;

/**
 * Created by lenovo on 2019/5/23.
 * 给0 - arr.length -1 的排列，我们将数组拆分成一些“块”，并对每个块进行单独排序。连接他们之后，结果等于排序后的数组。问最多能够分成多少个分区。
 *
 * 【解题思路】
 *      因为数组的排序后正确的顺序应该是 arr[i] 处的数是 i。
 *      1. 遍历数组，每次记录最大的数，如果最大的数的值为 i ，那么说明这个数是自己的位置是正确的，同时也说明这个数的前面的数都能放到自己正确的位置，所以当前数和前面的数可以放到一个块中。
 *
 */
public class _769_Max_Chunks_To_Make_Sorted {
    public int maxChunksToSorted(int[] arr) {
        int ret = 0;
        int max = arr[0];
        for(int i = 0; i < arr.length; i++) {
            max = Math.max(max,arr[i]);
            if(max == i)
                ret ++;
        }
        return ret;
    }
}
