package leetcode.string.math;

/**
 * Created by lenovo on 2019/4/22.
 * 大数相乘
 */
public class _43_Multiply_Strings {
    public String multiply(String num1, String num2) {
        int length1 = num1.length(), length2 = num2.length();
        int[] ret = new int[length1 + length2 - 1];  // 首先是让两个数组对应的元素相乘，然后相加到对应的相同的位置即可。
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length1; i++) {
            for(int j = 0; j < length2; j++) {
                ret[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        int carry = 0;
        for(int i = ret.length - 1; i >= 0; i--) {
            int num = ret[i] + carry;
            if(num > 9) {
                carry = num / 10;
                num %= 10;
            } else
                carry = 0;
            sb.insert(0, Integer.toString(num));
        }
        if(carry > 0) // 说明最后一个数相加的时候变为两位数了
            sb.insert(0,Integer.toString(carry));
        while(sb.length() > 0 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        if(sb.length() == 0)
            return "0";
        return sb.toString();
    }
}
