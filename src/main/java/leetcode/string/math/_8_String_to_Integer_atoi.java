package leetcode.string.math;

/**
 * Created by lenovo on 2019/5/21.
 * 将字符串转换为整型数
 * 【解题思路】
 *      1. 首先要将空格去掉。
 *      2. 然后判断符号，使用一个整型数来表示符号是正号还是负号，正号 -> 1， 负号 -> -1
 *      3. 继续判断如果是正常的数字字符，就进行字符的处理。 注意这里面需要处理一个整数溢出问题。
 */
public class _8_String_to_Integer_atoi {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0)
            return 0;
        int num = 0;
        int index = 0;
        int sign = 1;
        while(index < str.length() && str.charAt(index) == ' ')  // 如果有空格就将空格去掉
            index ++;
        if(index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')) // 判断符号，如果是正号，就是1， 如果是负号，就是 -1
            sign = (str.charAt(index ++) == '+') ? 1 : -1;
        while(index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') { // 如果是正常的数字字符，就进行字符的处理
            if(num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && str.charAt(index) - '0' > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + (str.charAt(index++) - '0');
        }
        return num * sign;
    }
}
