package leetcode.dp.palindromic_substrings;

/**
 * Created by lenovo on 2019/4/15.
 * 最长回文子串
 * 这个题跟 648题求给定字符串的回文串的个数差不多，只是多了一点长度的判断，返回最大的长度字符串，所以要记录最大长度字符串的起始位置和下标
 */
public class _5_Longest_Palindromic_Substring {
    int retStart,max; // 最长回文串的起始位置 和 最长回文串的长度
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 2) return s;
        for(int i = 0 ; i < s.length(); i++) {
            Palindromic(s, i, i);  // 这个是中间有一个元素向左右两边走
            Palindromic(s, i, i + 1);  // 这个是中间有两个元素，向左右两边走
        }
        return s.substring(retStart,retStart + max);
    }

    private void Palindromic(String s, int start, int end) {
        if(s == null || s.length() == 0) return;
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
             start --; end ++;
        }
        if(max < end - start - 1) {  // 判断最长的长度
            retStart = start + 1;
            max = end - start - 1;
        }
    }
}
