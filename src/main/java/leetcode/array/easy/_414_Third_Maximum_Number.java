package leetcode.array.easy;

/**
 * Created by lenovo on 2019/5/10.
 * 找到数组中第三大的元素
 *
 * 有很多边界条件要处理，很烦
 */
public class _414_Third_Maximum_Number {
    public int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for(int i : nums) {
            if(i > max) {
                third = second;
                second = max;
                max = i;
            }else if(i > second && i < max) {
                third = second;
                second = i;
            }else if(i > third && i < second) {
                third = i;
            }
        }
        return (int) (third == Long.MIN_VALUE ? max:third);
    }

    public static void main(String[] args) {
        _414_Third_Maximum_Number test = new _414_Third_Maximum_Number();
        int []a = {2,2,3,1};
        test.thirdMax(a);
        System.out.println(Integer.MIN_VALUE);
    }
}
