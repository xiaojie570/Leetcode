package leetcode.array.math;

/**
 * Created by lenovo on 2019/5/14.
 * 给一个非负的整数，你最多交换两个元素，使得这个数编程最大值。返回这个最大值
 * 【解题思路】
 *      1. 使用一个额外的桶，将元素作为下标，元素的下标作为值存储在数组中
 *      2. 然后循环遍历。
 */
public class _670_Maximum_Swap {
    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int[] bucket = new int[10];
        for(int i = 0; i < arr.length; i++)
            bucket[arr[i] - '0'] = i;
        for(int i = 0; i < arr.length;i++) {
            for(int j = 9; j > arr[i] - '0'; j--) {
                if(bucket[j] > i) {
                    char temp = arr[i];
                    arr[i] = arr[bucket[j]];
                    arr[bucket[j]] = temp;
                    return Integer.valueOf(new String (arr));
                }
            }
        }
        return num;
    }
}
