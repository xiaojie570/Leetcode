package leetcode.array.two_pointer;

/**
 * Created by lenovo on 2019/5/9.
 * 找到给定数组的中轴
 * 中轴是指，轴左边的元素和 = 轴右边的元素和
 * 【解题思路】
 *   定义一个数组，每一位记录当前元素到前面的所有元素的和。这样计算差值比较就可以了。
 */
public class _724_Find_Pivot_Index {
    public int pivotIndex(int[] nums) {
        int sum = 0, leftSum = 0;
        int[] record = new int[nums.length + 1];
        record[0] = 0;
        for(int i = 1; i <= nums.length ;i++) {
            record[i] = record[i - 1] + nums[i - 1];
        }
        for(int i = 0; i < nums.length ;i++) {
            if(record[i] == record[record.length - 1] - record[i + 1])
                return i;
        }
        return -1;
    }
}
