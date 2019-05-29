package leetcode.array.subarray;
/**
 * Created by lenovo on 2019/5/15.
 * 找到给定数组的所有子数组
 * 然后返回所有子数组中最小元素的和
 */
public class _907_Sum_of_Subarray_Minimums {
    public int sumSubarrayMins(int[] A) {
        int top1 = 0;
        int[] nums = new int[A.length];
        int[] lens = new int[A.length];
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        //71 55 82 55
        //1  2  1  4
        for(int i = 0; i < A.length; i++){
            int len = 1; //
            while(top1 > 0 && nums[top1 - 1] >= A[i] ){  // 从右边往左边
                len += lens[top1 -1]%(1000000007);
                top1--;
            }
            nums[top1] = A[i];  // 将A中的元素移到nums中
            lens[top1++] = len;  // 长度为 1
            left[i] = len;  //
        }
        top1 = 0;
        for(int i = A.length - 1; i >= 0; i--){
            int len = 1;
            while(top1 > 0 &&  nums[top1 -1] > A[i]){
                len +=  lens[top1 -1 ]%(1000000007);
                top1--;
            }
            nums[top1] = A[i];
            lens[top1++] = len;
            right[i] = len;
        }
        int ans = 0;
        for(int i = 0; i < left.length; i++){
            ans =(int) (ans + 1L *left[i] * right[i] * A[i])%1000000007;
        }
        return ans;
    }
}