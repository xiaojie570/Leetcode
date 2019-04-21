package leetcode.string.substring;

/**
 * Created by lenovo on 2019/4/21.
 * 不重复字符的最长子字符串
 * 【解题思路】
 *  1. 两个for循环，第一个for循环遍历给定字符串的每个字符，当前遍历到的字符下标为cur。
 *  2. 第二个for循环，记录第一个字符的位置first，并且保证first和对应cur位置的值不一样。 如果一样，就说明有了重复的元素了。
 */
public class _3_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() < 1) return 0;
        char[] arr = s.toCharArray();
        int cur = 1, first = 0;
        int length = 1;
        for(cur = 1; cur < s.length(); cur ++) {
            for(int j = first; j < cur; j++) {
                if(s.charAt(cur) == s.charAt(j)) {
                    first = j + 1;
                    break;
                }
            }
            length = Math.max((cur - first + 1), length);
        }
        return length;
    }
}
