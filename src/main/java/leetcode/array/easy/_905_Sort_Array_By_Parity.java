package leetcode.array.easy;

/**
 * Created by lenovo on 2019/4/13.
 * 给定数组，把奇数放到后边，偶数放到前边
 * 【解题思路】
 *      两个指针，签到题
 *
 *      CSDN： https://blog.csdn.net/xiaojie_570/article/details/91799521
 */
public class _905_Sort_Array_By_Parity {
    public int[] sortArrayByParity(int[] A) {
        int left = 0, right = A.length - 1;
        while(left < right) {
            while(left < A.length && A[left] % 2 == 0) left ++;
            while(right >= 0 && A[right] % 2 != 0) right --;
            if(left < right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left ++; right--;
            }
        }
        return A;
    }
}
