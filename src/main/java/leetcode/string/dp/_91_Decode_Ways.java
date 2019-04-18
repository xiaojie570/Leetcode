package leetcode.string.dp;

/**
 * Created by lenovo on 2019/4/18.
 * 给定字符串1-26中，可以组成多少个不同的字符串。
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 */
public class _91_Decode_Ways {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int ret = s.charAt(0) == 0 ? 0: 1;
        int last = 1;
        for(int i = 1;i < s.length(); i++) {
            int temp = ret;
            if(s.charAt(i) == '0') {
                if(s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    ret = last;
                } else return 0;
            } else if(s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) <= '6'){
                ret += last;
            }
            last = temp;
        }
        return  ret;
    }
}
