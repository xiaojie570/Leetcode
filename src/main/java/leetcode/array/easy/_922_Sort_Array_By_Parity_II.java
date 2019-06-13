package leetcode.array.easy;

/**
 * Created by lenovo on 2019/4/13.
 * 给定一个数组，其中奇数和偶数各一半，要求返回的数组中，奇数下标中的元素为奇数，偶数索引下标中的元素为偶数。(905题的扩展)
 * 【解题思路】
 *      两个指针，指针每次移动两个位置
 *
 *      CSDN: https://blog.csdn.net/xiaojie_570/article/details/91811083
 */
public class _922_Sort_Array_By_Parity_II {
    public int[] sortArrayByParityII(int[] A) {
        if(A == null || A.length == 0) return A;
        int left = 0, right = A.length - 1;
        for(; left < A.length && right >= 0;) {
            while(left < A.length  && A[left] % 2 == 0) left += 2;
            while(right >= 0 && A[right] % 2 != 0) right -= 2;
            if(left < A.length  && right >= 0) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
            }
        }
        return A;
    }
}
