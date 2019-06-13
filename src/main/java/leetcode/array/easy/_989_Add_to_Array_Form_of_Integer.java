package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2019/5/9.
 * 给定一个数组，和一个元素，将元素加到数组中。
 * 【解题思路】
 *      1. 从后面往前面遍历数组，每一位都加k，然后更新对应的元素的值，更新k
 *      2. 最后如果k不为0，说明元素的第一位加完溢出了，说明还需要第一位将溢出的k加上就可以了。
 *
 *      CSDN: https://blog.csdn.net/xiaojie_570/article/details/91829848
 */
public class _989_Add_to_Array_Form_of_Integer {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> ret = new ArrayList<Integer>();
        int i = A.length - 1;
        while(K > 0 && i >= 0) {
            int sum = A[i] + K;
            A[i] = sum % 10;
            K = sum / 10;
            i --;
        }
        while(K > 0) {
            ret.add(0,K % 10);
            K /= 10;
        }
        for(int num: A)
            ret.add(num);
        return ret;
    }
}
