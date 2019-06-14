package leetcode.array.sum;

/**
 * Created by lenovo on 2019/4/11.
 * 输入有序的字符数组，找到和为定值的两个数的下标
 * 【解题思路】
 *  1. 使用两个变量，第一个变量 i 指向数组的第一个下标，第二个变量 j 指向数组的最后一个下标
 *  2. 如果当前两个下标的值小于目标值，则将i ++, 如果大于目标值，则将 j -- ,否则找到了符合要求的变量，直接返回。
 *
 * CSDN: https://blog.csdn.net/xiaojie_570/article/details/91973868
 */
public class _167_Two_Sum_II_Input_array_is_sorted {
    public int[] twoSum(int[] numbers, int target) {
        int s=0,h=numbers.length-1;
        while(s<h)
        {
            if(numbers[s]+numbers[h]>target)
            {
                h--;
            }else if(numbers[s]+numbers[h]<target)
            {
                s++;
            }else{
                return new int[]{s+1,h+1};
            }
        }
        return null;
    }
    public static void main(String[] args) {
        int[] nums = {5,25,75};
        _167_Two_Sum_II_Input_array_is_sorted test = new _167_Two_Sum_II_Input_array_is_sorted();
        int [] ret = test.twoSum(nums,100);
        for(int i : ret)
            System.out.println(i);
    }
}
