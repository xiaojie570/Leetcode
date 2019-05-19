package leetcode.string.stack;

/**
 * Created by lenovo on 2019/5/19.
 *  返回括号的分数。规则：
 *  1. () 得 1 分
 *  2. AB得 A+B 分，其中A和B是平衡括号字符串
 *  3. (A)得 2 * A 分，其中A是平衡括号字符串
 *
 *  【解题思路】
 *        计算括号，就计算当前自己这个括号的价值就可以了，然后再加上别人的价值。
 */
public class _856_Score_of_Parentheses {
    public int scoreOfParentheses(String S) {
        int ret = 0;
        int balance = 0;
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '(') { //如果是左括号
                balance ++;
            } else {
                balance --;
                if(S.charAt(i - 1) == '(') {// 如果当前括号的前面还是左括号，那么就算一下当前括号的价值
                    ret += 1 << balance;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(1 << 0);
    }
}
