package leetcode.string.substring;

/**
 * Created by lenovo on 2019/5/7.
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 *  判断给定的字符串的子串是不是重复的子串
 *  【解题思路】
 *      1. 只要遍历到给定字符的一半即停止
 *      2. 第一次遍历一个字符，第二次遍历2个字符，第三次遍历3个字符。
 */
public class _459_Repeated_Substring_Pattern {
    public boolean repeatedSubstringPattern(String s) {
        for(int i = 0; i < s.length() / 2; i++) {
            if(s.length() %(i + 1) != 0)
                continue;
            int len = i + 1;
            String subString = s.substring(0,len);
            boolean successs = true;
            for(int j = len; successs &&((j + len) <= s.length()); j+= len) {
                String test = s.substring(j,j + len);
                successs &= test.equals(subString);
            }
            if(successs)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        _459_Repeated_Substring_Pattern test = new _459_Repeated_Substring_Pattern();
        test.repeatedSubstringPattern("abcabcabcabc");

    }
}
