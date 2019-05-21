package leetcode.string.medium;

/**
 * Created by lenovo on 2019/5/21.
 * 判断给定的字符串能否正确的匹配括号对。带有小星星的
 */
public class _678_Valid_Parenthesis_String {
    public boolean checkValidString(String s) {
        boolean ret = false;
        if(s == null || s.length() == 0)
            return true;
        int left = 0, star = 0;
        char[] arr = s.toCharArray();
        for(int i = 0; i < s.length(); i++) { // 从前往后扫一波
            if(arr[i] == '(') {
                left++;
            } else if(arr[i] == ')') {
                if(left == 0) {
                    if(star == 0) return ret;
                    star --;
                } else {
                    left --;
                }
            } else if(arr[i] == '*')
                star ++;
        }
        left = star = 0;
        for(int i = s.length() - 1; i >= 0; i --) { // 再从后往前扫一波  如果没有这个循环，那么对于 '(' 返回的就是 true,这就不对了。
            if(arr[i] == ')') {
                left ++;
            } else if(arr[i] == '(') {
                if(left == 0) {
                    if(star == 0)
                        return ret;
                    star --;
                } else
                    left --;
            } else if(arr[i] == '*')
                star ++;
        }
        return true;
    }
}
