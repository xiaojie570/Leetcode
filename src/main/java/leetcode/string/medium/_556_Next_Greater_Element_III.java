package leetcode.string.medium;

import java.util.Arrays;

/**
 * Created by lenovo on 2019/5/21.
 * 找比当前数更大的数，但是字符的组成不能变
 * 【解题思路】
 *      使用dowhile循环。
 *      1. 首先将整数转换为字符串形式，然后从字符串的最后开始向前找元素。
 */
public class _556_Next_Greater_Element_III {
    public int nextGreaterElement(int n) {
        if(n<10) return -1;
        char[] num = Integer.valueOf(n).toString().toCharArray();
        int i = num.length-1;

        do{
            char[] tail = Arrays.copyOfRange(num, i, num.length); // 先从数组中从后向前截取部分元素，然后将这个截取数组排序
            Arrays.sort(tail);
            for(int j=0;j<tail.length;j++){
                if(tail[j]>num[i-1]) {  // 如果当前排序后的元素比真实的元素大，就说明找到了需要调换的位置
                    char swap = tail[j];
                    tail[j]=num[i-1];
                    num[i-1] = swap;

                    String head = new String(Arrays.copyOf(num, i)); // 保留要调换元素的前面的所有元素
                    String nextGreater = head + new String(tail); // 添加调换元素后面的已经换好顺序的元素
                    try{
                        return Integer.parseInt(nextGreater);
                    }catch (Exception ex){
                        return -1;
                    }
                }
            }
        }while(--i>0);

        return -1;
    }
}
