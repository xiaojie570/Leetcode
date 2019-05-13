package leetcode.array.medium;

/**
 * Created by lenovo on 2019/5/13.
 * 给一个二进制数组，反转数组中的元素，最少反转几个元素 数组是一个递增的数组
 */
public class _926_Flip_String_to_Monotone_Increasing {
    public int minFlipsMonoIncr(String S) {
        int num1 = 0, num0 = 0;
        for(char c: S.toCharArray()) {
            num1 = Math.min(num0,num1) + (c == '1' ? 0:1); // 想要1结尾的数，所以当前数是1就不加
            num0 += (c == '0' ? 0 : 1); // 想要0结尾的数，所以当前数是0就不加
        }
        return Math.min(num0,num1);
    }
}
