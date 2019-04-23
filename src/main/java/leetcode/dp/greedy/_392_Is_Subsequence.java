package leetcode.dp.greedy;

/**
 * Created by lenovo on 2019/4/23.
 * 判断一个字符串是不是另一个字符串的子串。（字符相同相对顺序相同）
 */
public class _392_Is_Subsequence {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        if(s.length() > t.length()) return false;
        for(int i = 0,index = 0; i < s.length(); i++, index ++) {
            index = t.indexOf(s.charAt(i),index); // 要加一个从哪里开始，因为可能s中会有2个以上相同的字母出现。这个很容易错
            if(index < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "abcd";
        String b = "sadcrebcs";
        int i = 0;
        System.out.println(b.indexOf(a.charAt(2),3));
    }
}
