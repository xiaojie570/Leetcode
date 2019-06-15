package leetcode.string.easy;

import java.util.Arrays;

/**
 * Created by lenovo on 2019/5/8.
 * 找到数组中出现次数大于元素总数一半的元素值
 * 【解题思路】
 *      思路一：排序然后再找
 *      思路二：不需要排序，如果当前元素元素和前面的元素不一样，就将count--，如果一样就 count++。这个方法很好。。。
 *      、
 *
 *   CSDN: https://blog.csdn.net/xiaojie_570/article/details/92197191
 */
public class _169_Majority_Element {
    public int majorityElement(int[] nums) {
        int cur_num =0; // 当前的数
        int count =0;

        for(int num: nums){
            if(count ==0){ // 如果count等于0，说明相同的元素已经没有了，需要重新计算当前元素为相同的元素。
                cur_num = num;
                count++;
            }else{
                if(num == cur_num){
                    count++;
                }else{
                    count--;
                }
            }
        }
        return cur_num;
    }
}
