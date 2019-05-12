package leetcode.array.modify;

/**
 * Created by lenovo on 2019/5/10.
 * 给一个长度为n的数组，判断它是否可以变成一个非递增数组，要求最多修改一个元素。
 */
public class _665_Non_decreasing_Array {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i-1]) { // 如果满足递增的条件，就直接进行下一次循环
                continue;
            }
            if (count > 0) {  // 到这里说明已经有第二次不满足递增的条件了，所以要返回false
                return false;
            }
            count++; // 到这里说明不满足递增的条件，所以要记录不满足的次数
            if (i - 2 < 0 || nums[i-2] <= nums[i]) { // 调整当前的元素的值，使得他满足递增数组的条件
                nums[i-1] = nums[i];
            } else {
                nums[i] = nums[i-1];
            }
        }
        return true;
    }


    public static void main(String[] args) {
        _665_Non_decreasing_Array test = new _665_Non_decreasing_Array();
        int[] a = {4,2,1};
        test.checkPossibility(a);
    }
}
