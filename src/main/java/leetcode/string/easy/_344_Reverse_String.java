package leetcode.string.easy;

/**
 * Created by lenovo on 2019/4/16.
 * 反转字符数组
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 */
public class _344_Reverse_String {
    public void reverseString(char[] s) {
        if(s == null || s.length == 0) return;
        int start = 0, end = s.length - 1;
        while(start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start ++; end --;
        }
    }
}
