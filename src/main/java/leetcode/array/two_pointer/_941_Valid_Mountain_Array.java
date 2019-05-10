package leetcode.array.two_pointer;

/**
 * Created by lenovo on 2019/5/10.
 * 找到给定的数组是否是一个Mountains 数组 ,Mountains 数组的定义：
 * 有一个轴，这个轴两边
 * 1. 左边比右边小，
 * 2. 右边比左边小
 */
public class _941_Valid_Mountain_Array {
    public boolean validMountainArray(int[] A) {
        int left = 0, right = A.length - 1;
            while(left < right && left < A.length - 1 && A[left] < A[left + 1]) left ++;
            while(left < right && right > 0 && A[right] < A[right - 1]) right --;
            if(left == right && left != 0 && right != A.length - 1)
                return true;
        return false;
    }

    public static void main(String[] args) {
        _941_Valid_Mountain_Array test = new _941_Valid_Mountain_Array();
        int[] a = {2,1};
        test.validMountainArray(a);
    }
}
