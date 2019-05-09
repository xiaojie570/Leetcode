package leetcode.array.easy;

/**
 * Created by lenovo on 2019/5/9.
 * 找到数组中三个数相乘乘积最大的结果
 *
 */
public class _628_Maximum_Product_of_Three_Numbers {
    public int maximumProduct(int[] nums) {
        int minFirst = Integer.MAX_VALUE; // 最小
        int minSecond = Integer.MAX_VALUE;  // 倒数第二小
        int maxFirst = Integer.MIN_VALUE;  // 最大
        int maxSecond = Integer.MIN_VALUE; // 第二大
        int maxThird = Integer.MIN_VALUE; // 第三大
        for(int num : nums) {
            if(num >= maxFirst) {
                maxThird = maxSecond;
                maxSecond = maxFirst;
                maxFirst = num;
            } else if(num >= maxSecond) {
                maxThird = maxSecond;
                maxSecond = num;
            } else if(num >= maxThird)
                maxThird = num;
            if(num <= minFirst) {
                minSecond = minFirst;
                minFirst = num;
            } else if(num <= minSecond)
                minSecond = num;
        }
        return Math.max(maxFirst * minFirst * minSecond, maxFirst * maxSecond * maxThird);
    }

    public static void main(String[] args) {
        _628_Maximum_Product_of_Three_Numbers test = new _628_Maximum_Product_of_Three_Numbers();
        int[] a = {1,2,3,4};
        test.maximumProduct(a);
    }
}
