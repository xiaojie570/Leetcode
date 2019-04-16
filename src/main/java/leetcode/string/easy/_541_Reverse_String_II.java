package leetcode.string.easy;

/**
 * Created by lenovo on 2019/4/16.
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * 反转的元素，有反转个数和间隔。
 */
public class _541_Reverse_String_II {
    public String reverseStr(String s, int k) {
        int length = s.length();
        char[] arr = s.toCharArray();
        for(int i = 0; i < length; i += 2*k) { // 主要是这个地方
            reverse(arr, i, k);
        }
        return String.valueOf(arr);
    }

    private void reverse(char[] s, int start, int k) {
        int index = start + k - 1;
        if(index > s.length - 1) index = s.length - 1;
        while(start < index) {
            char temp = s[start];
            s[start] = s[index];
            s[index] = temp;
            start ++; index --;
        }
    }
}
