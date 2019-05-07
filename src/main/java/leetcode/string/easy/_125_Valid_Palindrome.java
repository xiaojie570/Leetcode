package leetcode.string.easy;

import java.util.Arrays;

/**
 * Created by lenovo on 2019/5/7.
 * 判断给定的字符串是否是回文字符串。
 * 【解题思路】
 *      1. 将是字符的元素放到新的字符数组中
 *      2. 再对新的字符数组进行比较是否是回文串
 */
public class _125_Valid_Palindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        if(s == null || s.length() == 0)
            return true;
        char[] array = s.toCharArray();
        char[] a = new char[array.length];
        int index = 0, start = 0, end = s.length() - 1;
        for(int i = 0; i < s.length();i++) {
            if((array[i] >= 'a' && array[i] <= 'z') || (array[i] >= 'A' && array[i] <= 'Z') || (array[i] >= '0' && array[i] <= '9')){
                a[index ++] = array[i];
            }
        }
        end = index - 1;
        a = Arrays.copyOf(a,index); // 删除没有用到的元素位置
        while(start < end) {
            if(!(a[start] == a[end])) {
                return false;
            }
            start ++; end --;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "race a car";
        _125_Valid_Palindrome test = new _125_Valid_Palindrome();
        test.isPalindrome(s);
        System.out.println(!("op".charAt(1) >= 'a' && "op".charAt(1) <= 'x'));
    }
}
