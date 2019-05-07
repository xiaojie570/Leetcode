package leetcode.string.math;

/**
 * Created by lenovo on 2019/5/7.
 * 二进制数相加
 */
public class _67_Add_Binary {
    public String addBinary(String a, String b) {
        char[] charsA = a.toCharArray(), charsB = b.toCharArray();
        char[] sum = new char[Math.max(a.length(), b.length()) + 1];
        int carry = 0, index = sum.length - 1;
        for (int i = charsA.length - 1, j = charsB.length -1; i >= 0 || j>= 0; i--, j--) {
            int aNum = i < 0 ? 0 : charsA[i] - '0';
            int bNum = j < 0 ? 0 : charsB[j] - '0';

            int s = aNum + bNum + carry;
            sum[index--] = (char) (s % 2 + '0');
            carry = s / 2;
        }
        sum[index] = (char) ('0' + carry);
        return carry == 0 ? new String(sum, 1, sum.length - 1) : new String(sum);
    }
}
