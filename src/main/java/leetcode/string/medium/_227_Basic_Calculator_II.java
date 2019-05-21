package leetcode.string.medium;

/**
 * Created by lenovo on 2019/5/20.
 * 字符串来进行加减乘除运算
 */
public class _227_Basic_Calculator_II {
    public int calculate(String s) {
        char sign = '+';
        int pre = 0; // 是为了乘法和除法设置的
        int ret = 0; // 返回值
        int num = 0; // 单个元素的值
        for(int i = 0; i <= s.length(); i++) {
            char cur = i == s.length() ? '+' : s.charAt(i);
            if(cur == ' ')
                continue;
            if(cur >= '0' && cur <= '9') {
                num = 10 * num + (cur - '0');
            } else {
                if(sign == '+') {
                    ret += num;
                    pre = num;
                }
                if(sign == '-') {
                    ret -= num;
                    pre = -num;
                }
                if(sign == '*') {
                    ret -= pre; // 要把前一个数减掉，因为前一个数要跟现在这个数先做乘法再加在一起
                    pre *= num;
                    ret += pre;
                }
                if(sign == '/') {
                    ret -= pre;
                    pre /= num;
                    ret += pre;
                }
                sign = cur;
                num = 0;
            }
        }
        return ret;
    }
}
