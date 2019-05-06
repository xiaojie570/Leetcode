package leetcode.string.easy;

/**
 * Created by lenovo on 2019/5/6.
 * Input: name = "alex", typed = "aaleex"
 * Output: true
 * Explanation: 'a' and 'e' in 'alex' were long pressed.
 * 电话号码是否多按了。
 *
 */
public class _925_Long_Pressed_Name {
    public boolean isLongPressedName(String name, String typed) {
        if(name.equals(typed)) return true;
        int sum = 0;
        for(int i = 0; i < typed.length() && sum < name.length(); i++) {
            if(name.charAt(sum) == typed.charAt(i))  sum ++;
            else if(i == 0 || typed.charAt(i) != typed.charAt(i - 1))
                return false;
        }
        return sum == name.length();
    }
}
