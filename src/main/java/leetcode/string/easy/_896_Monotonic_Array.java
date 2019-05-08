package leetcode.string.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lenovo on 2019/5/8.
 * 判断一个数组是不是单调的。单调包括单调递增和单调递减。
 * 【解题思路】
 *      1. 定义一个变量，该变量的值 = 0 表示相等， 1表示 降序， 2表示升序
 */
public class _896_Monotonic_Array {
    public boolean isMonotonic(int[] A) {
        if(A == null || A.length == 0)
            return false;
        if(A.length == 1)
            return true;
        int compare = 0;
        for(int i =0 ; i < A.length - 1; i++) {
            if(A[i] < A[i + 1]) {
                if(compare == 0) compare = 1;
                else if(compare == 2) return false;
            } else if(A[i] > A[i + 1]) {
                if(compare == 0) compare = 2;
                else if(compare == 1) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _896_Monotonic_Array test = new _896_Monotonic_Array();
        int[] a = {6,5,4,4};
        test.isMonotonic(a);
    }
}
