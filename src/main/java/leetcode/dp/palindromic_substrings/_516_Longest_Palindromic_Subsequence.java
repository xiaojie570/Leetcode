package leetcode.dp.palindromic_substrings;

/**
 * Created by lenovo on 2019/4/15.
 * 最长回文子串长度，回文串可以不连续
 */
public class _516_Longest_Palindromic_Subsequence {
    public int longestPalindromeSubseq(String s) {
        int ret = 0;
        if(s == null || s.length() == 0) return 0;
        for(int i = 0; i < s.length(); i++) {
            int r1 = Palindrome(s, i, i);
            int r2 = Palindrome(s, i, i + 1);
            ret = Math.max(ret,Math.max(r1,r2));
        }
        return ret;
    }

    private int Palindrome(String s, int start, int end) {
        if(s == null || s.length() == 0) return 0;
        int count = 0;
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count ++; start --; end ++;
        }
        return count;
    }
}
